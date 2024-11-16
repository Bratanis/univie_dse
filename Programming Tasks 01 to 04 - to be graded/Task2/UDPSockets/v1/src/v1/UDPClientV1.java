package v1;

import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//Task 2.1______________________________________________________________________________________
public class UDPClientV1 {
	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(UDPClientV1.class.getName());
	static {
		Logger.getLogger("UDPClientV1").setLevel(Level.ALL);
	}
	
	public static void main(String[] args) throws IOException {
		
		int clientInt = 2;	
		
		//Register service
		DatagramSocket s = null; 
		
		try {
			s = new DatagramSocket();
            ByteBuffer byteBuffer = ByteBuffer.allocate(4);		
            byteBuffer.putInt(clientInt);
            InetAddress host = InetAddress.getByName("localhost");
            int serverPort = 2345;
			//while (true) {
				
			    logger.info("Sending to server: " + clientInt);
				DatagramPacket request = new DatagramPacket(byteBuffer.array(), 
															byteBuffer.capacity(),
															host, serverPort);
				s.send(request);
				
				//clear the buffer so we can store the reply in it
				byteBuffer.clear();
				
				DatagramPacket reply = new DatagramPacket(  byteBuffer.array(),
															byteBuffer.capacity());
				s.receive(reply);
				clientInt = byteBuffer.getInt();
				logger.info("Received from server: " + clientInt);
			//}
		} catch (SocketException e) {
			logger.warning("Socket: " + e.getMessage());
		} catch (IOException e) {
			logger.warning("IO: " + e.getMessage());
		} finally {
			
			System.out.println("The final result is: " + clientInt);
			
			if (s != null) {
				s.close();
			}
		}
	}
}



