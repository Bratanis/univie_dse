package v3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import messageV3.Message;

// Directions from:
// https://stackoverflow.com/questions/26226688/converting-from-datagrampacket-to-int
// https://www.geeksforgeeks.org/java-nio-bytebuffer-class-in-java/

public class UDPServerV3 {

	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(UDPServerV3.class.getName());
	static {
		Logger.getLogger("UDPServerV3").setLevel(Level.ALL);
	}
	
	public static void main(String[] args) throws IOException{
		
		//Register service
		DatagramSocket s = null; 
		int serverPort = 2345;
		try {
			s = new DatagramSocket(serverPort);

            int numOfBlobSizes = 6;
            int iterationsPerBlobSize = 10;

            int totalIterations = iterationsPerBlobSize*numOfBlobSizes;
            logger.info("The server will run for " + totalIterations + " iterations!");
            
			for (int iteration = 0; iteration < totalIterations; ++iteration) {

				 // 65535 Bytes is the maximum size a UDP-Datagram can be!
				ByteBuffer clientMessageBuffer = ByteBuffer.allocate(65535);		
				DatagramPacket request = new DatagramPacket(clientMessageBuffer.array(), 
															clientMessageBuffer.capacity());
				s.receive(request);
				
				Message requestMessage = Message.deserialize(clientMessageBuffer);
			    logger.info("Received from client: " + requestMessage);

			    requestMessage.incrementNum();
				logger.info("Sending back: " + requestMessage);

				clientMessageBuffer = requestMessage.serialize(); // Prepare the message for sending
		        ByteBuffer responseBuffer = requestMessage.serialize();	
		        
				DatagramPacket reply = new DatagramPacket(  responseBuffer.array(),
															responseBuffer.capacity(),
															request.getAddress(),
															request.getPort());
				s.send(reply);
			}
		} catch (SocketException e) {
			logger.warning("Socket: " + e.getMessage());
		} catch (IOException e) {
			logger.warning("IO: " + e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}


