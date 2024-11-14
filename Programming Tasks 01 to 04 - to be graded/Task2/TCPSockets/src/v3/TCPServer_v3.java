package v3;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



//Task 2.3______________________________________________________________________________________
public class TCPServer_v3 {

		//For Debugging_________________________________
		private static final Logger logger = Logger.getLogger(TCPServer_v3.class.getName());
		static {
			Logger.getLogger("TCPServer_v3").setLevel(Level.WARNING);
		}

public static void main(String[] args) throws IOException, ClassNotFoundException{
	
		//Register service
		ServerSocket s = new ServerSocket(1254);
		logger.info("Server listening!");
		
		//Wait and accept connection (in another socket)
		Socket s1 = s.accept();
		logger.info("Connection established!");
		
		//Create input and output communication streams
	    ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
	    ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
	    
	    //loop that will accept, increment and return 6000 messages 
	    //(1000 for each the 6 different dataBlob sizes )
	    for (int i = 0; i < 6000; ++i) {
		    //Read integer from client
		    Message_v3 receivedMsg = (Message_v3) ois.readObject();
		    logger.info("Received from client: " + receivedMsg);
		    
		    //Increment integer in Message
		    receivedMsg.incrementNum();
			logger.info("Incremented value: " + receivedMsg);
		    
		    // Send incremented integer back to client
		    oos.writeObject(receivedMsg);
	    }
	    //Terminate connection
	    ois.close();
	    oos.close();
	    s1.close();
	    s.close();
	}
}
