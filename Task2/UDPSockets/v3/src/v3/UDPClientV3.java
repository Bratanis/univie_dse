package v3;

import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import messageV3.Message;


// Some functionality was taken from my TCP v3 implementation
public class UDPClientV3 {
	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(UDPClientV3.class.getName());
	static {
		Logger.getLogger("UDPClientV3").setLevel(Level.ALL);
	}
	
	private static final int MAX_PACKAGE_SIZE = 65487; // Since the packages will not be sent over the internet,
													   // we can set a realtively high payload size. Otherwise it 
													   // might make sense to keep the payload below 1,472 B!
	
	private static long getAvgTransmissionTime(long[] receivedMsgTimestamps) {
		//Make sure there is a valid number of time stamps in the array
		if (receivedMsgTimestamps == null || receivedMsgTimestamps.length < 2) {
			logger.warning("Did not receive enough transmission timestamps to compute a valid average!");
	        return 0;
	    }
	    
	    long totalTransmissionTime = 0;
	    
	    //Calculate the total transmission time between every two time stamps
	    for (int i = 0; i < receivedMsgTimestamps.length - 1; ++i) {
	        totalTransmissionTime += receivedMsgTimestamps[i+1] - receivedMsgTimestamps[i];
	    }
	    
	    //Calculate the average transmission time
	    return totalTransmissionTime / (receivedMsgTimestamps.length - 1);
	}
	
	private static void printTransmissionTimes(long[] avgTransmissionTimes, int[] blobSizes) {
		for (int i = 0; i < blobSizes.length; ++i) {
			System.out.println("Messaage with a blob of size:" + blobSizes[i]
							   + "B have an average roundtrip transmission time of:"
							   + avgTransmissionTimes[i] + "ms.");
		}
	}

	
	public static ByteBuffer sendToServer(ByteBuffer requestBuffer, DatagramSocket s, InetAddress host, int serverPort) throws IOException {
		DatagramPacket request = new DatagramPacket(requestBuffer.array(), 
				requestBuffer.capacity(),
				host, serverPort);
				
			s.send(request);

		// Receive the reply
			byte[] responseBuffer = new byte[requestBuffer.capacity()];
			DatagramPacket reply = new DatagramPacket(responseBuffer, responseBuffer.length);
			s.receive(reply);

			// Get the message from the server reply
			ByteBuffer responseByteBuffer = ByteBuffer.wrap(reply.getData(), 0, reply.getLength());
			return responseByteBuffer;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		int clientInt = 2;	
		
		//Register service
		DatagramSocket s = null; 
		
		// V3 specific parameters
		int[] blobSizes = {1024, 2048, 4096, 8192, 16384, 131072};
		long[] avgTransmissionTimes = new long[blobSizes.length];
		int iterationsPerBlobSize = 10;
		
		try {
			s = new DatagramSocket();
            InetAddress host = InetAddress.getByName("localhost");
            int serverPort = 2345;

        	for(int blobSize = 0; blobSize < blobSizes.length; ++blobSize) {
        		
        		
        		Message clientMessage = new Message(blobSizes[blobSize], clientInt, "client1");

      		  	//Used to compute the average transmission time of the message
        		long[] receivedMsgTimestamps = new long[iterationsPerBlobSize]; 
	
        		for (int iterationForABlobSize = 0; iterationForABlobSize < iterationsPerBlobSize; ++iterationForABlobSize) {
        			//Save timestamp:
        			receivedMsgTimestamps[iterationForABlobSize] = clientMessage.getTimestampInMillis(); 
        	
        			// with small blobs, just send the message
        			if (!clientMessage.shouldBeFragmented()) {
        			
	        			// Send the message
		        		ByteBuffer requestBuffer = clientMessage.serialize();
					    
		                // Get the message from the server reply
		                ByteBuffer responseByteBuffer = sendToServer(requestBuffer, s, host, serverPort); 
		                clientMessage = Message.deserialize(responseByteBuffer);
	
        			} else { // If the blob is too big, fragment it and send the fragments one by one!
        				List<ByteBuffer> fragmentRequestBuffers = clientMessage.serializeLargeMessage();
        				List<ByteBuffer> fragmentResponseBuffers = new ArrayList();
        				for (ByteBuffer requestBuffer : fragmentRequestBuffers) {
        					ByteBuffer responseBuffer = sendToServer(requestBuffer, s, host, serverPort);
        					fragmentResponseBuffers.add(responseBuffer);
        				}
        				clientMessage = Message.deserializeLargeMessage(fragmentResponseBuffers);
        			}
        			
        			// Update the timestamp after roundtrip:
					clientMessage.updateTimestamp();
					logger.info("Received from server: " + clientMessage);
        		}
        		
      		  //calculate the average round trip time for the blob size and add it to the respective array
      		  avgTransmissionTimes[blobSize] = getAvgTransmissionTime(receivedMsgTimestamps);

			}
		} catch (SocketException e) {
			logger.warning("Socket: " + e.getMessage());
		} catch (IOException e) {
			logger.warning("IO: " + e.getMessage());
		} finally {
			
			printTransmissionTimes(avgTransmissionTimes, blobSizes);
			
			if (s != null) {
				s.close();
			}
		}
	}
}



