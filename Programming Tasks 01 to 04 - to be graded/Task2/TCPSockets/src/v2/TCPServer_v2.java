package v2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import v1.TCPServer_v1;


//Task 2.2______________________________________________________________________________________
public class TCPServer_v2 {

		//For Debugging_________________________________
		private static final Logger logger = Logger.getLogger(TCPServer_v1.class.getName());
		static {
			Logger.getLogger("TCPServer").setLevel(Level.OFF);
		}

public static void main(String[] args) throws IOException, ClassNotFoundException{
	
		//Register service
		ServerSocket s = new ServerSocket(1254);
		
		//Wait and accept connection (in another socket)
		Socket s1 = s.accept();
		logger.info("Connection established!");
		
		//Create input and output communication streams
	    ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
	    ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
	    
	    //Read integer from client
	    Message_v2 receivedMsg = (Message_v2) ois.readObject();
	    logger.info("Received from client: " + receivedMsg);
	    
	    //Increment integer in Message
	    receivedMsg.incrementNum();;
		logger.info("Incremented value: " + receivedMsg);
	    
	    // Send incremented integer back to client
	    oos.writeObject(receivedMsg);
	
	    //Terminate connection
	    ois.close();
	    oos.close();
	    s1.close();
	    s.close();
	}
}
