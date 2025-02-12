package v1;

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

public class UDPServerV1 {

	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(UDPServerV1.class.getName());
	static {
		Logger.getLogger("UDPServerV1").setLevel(Level.ALL);
	}
	
	public static void main(String[] args) throws IOException{
		
		//Register service
		DatagramSocket s = null; 
		int serverPort = 2345;
		try {
			s = new DatagramSocket(serverPort);
            ByteBuffer byteBuffer = ByteBuffer.allocate(4);		

			//while (true) {
				
				DatagramPacket request = new DatagramPacket(byteBuffer.array(), byteBuffer.capacity());
				s.receive(request);
				
				int requestedInt = byteBuffer.getInt();
			    logger.info("Received from client: " + requestedInt);
			    ++requestedInt;
				logger.info("Incremented value: " + requestedInt);
				byteBuffer.clear();
				byteBuffer.putInt(requestedInt);
				
				DatagramPacket reply = new DatagramPacket(  byteBuffer.array(),
															byteBuffer.capacity(),
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


