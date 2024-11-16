package v2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

// Directions from:
// https://stackoverflow.com/questions/26226688/converting-from-datagrampacket-to-int
// https://www.geeksforgeeks.org/java-nio-bytebuffer-class-in-java/

public class UDPServerV2 {

	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(UDPServerV2.class.getName());
	static {
		Logger.getLogger("UDPServerV2").setLevel(Level.ALL);
	}
	
	public static void main(String[] args) throws IOException{
		
		//Register service
		DatagramSocket s = null; 
		int serverPort = 2345;
		try {
			s = new DatagramSocket(serverPort);
            ByteBuffer clientMessageBuffer = ByteBuffer.allocate(100); // 100 Bytes should be more than enough 
            												  // for the message (for now)		

			//while (true) {
				
				DatagramPacket request = new DatagramPacket(clientMessageBuffer.array(), 
															clientMessageBuffer.capacity());
				s.receive(request);
				
				MessageV2 requestMessage = MessageV2.deserialize(clientMessageBuffer);
			    logger.info("Received from client: " + requestMessage);

			    requestMessage.incrementNum();
				logger.info("Sending back: " + requestMessage);

				clientMessageBuffer.clear(); // Clear the buffer, just in case 
				clientMessageBuffer = requestMessage.serialize(); // Prepare the message for sending
				
				DatagramPacket reply = new DatagramPacket(  clientMessageBuffer.array(),
															clientMessageBuffer.capacity(),
															request.getAddress(),
															request.getPort());
				s.send(reply);
			//}
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


