package v2;

import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//Task 2.1______________________________________________________________________________________
public class UDPClientV2 {
	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(UDPClientV2.class.getName());
	static {
		Logger.getLogger("UDPClientV2").setLevel(Level.ALL);
	}
	
	public static void main(String[] args) throws IOException {
		
		int clientInt = 2;	
		MessageV2 clientMessage = new MessageV2(clientInt, "client1");
		
		//Register service
		DatagramSocket s = null; 
		
		try {
			s = new DatagramSocket();
			ByteBuffer serializedMessage = clientMessage.serialize();
            InetAddress host = InetAddress.getByName("localhost");
            int serverPort = 2345;

			//while (true) {
				
			    logger.info("Sending to server: " + clientMessage);
				DatagramPacket request = new DatagramPacket(serializedMessage.array(), 
															serializedMessage.capacity(),
															host, serverPort);
				s.send(request);
				
				//clear the buffer so we can store the reply in it
				serializedMessage.clear();
				
				DatagramPacket reply = new DatagramPacket (serializedMessage.array(),
														   serializedMessage.capacity());
				s.receive(reply);
				clientMessage = MessageV2.deserialize(serializedMessage);
				logger.info("Received from server: " + clientMessage);
			//}
		} catch (SocketException e) {
			logger.warning("Socket: " + e.getMessage());
		} catch (IOException e) {
			logger.warning("IO: " + e.getMessage());
		} finally {
			
			System.out.println("The final result is: " + clientMessage);
			
			if (s != null) {
				s.close();
			}
		}
	}
}



