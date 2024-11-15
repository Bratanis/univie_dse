package v1;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//Task 2.1______________________________________________________________________________________
public class TCPServer_v1 {

		//For Debugging_________________________________
		private static final Logger logger = Logger.getLogger(TCPServer_v1.class.getName());
		static {
			Logger.getLogger("TCPServer").setLevel(Level.OFF);
		}
	
	public static void main(String[] args) throws IOException{
		
		//Register service
		ServerSocket s = new ServerSocket(1254);
		
		//Wait and accept connection (in another socket)
		Socket s1 = s.accept();
		logger.info("Connection established!");
		
		//Create input and output communication streams
        DataInputStream s1in = new DataInputStream(s1.getInputStream());
        DataOutputStream s1out = new DataOutputStream(s1.getOutputStream());
        
        //Read integer from client
        int receivedInt = s1in.readInt();
        logger.info("Received from client: " + receivedInt);
        
        //Increment integer
        int incrementedInt = receivedInt + 1;
		logger.info("Incremented value: " + incrementedInt);
        
        // Send incremented integer back to client
        s1out.writeInt(incrementedInt);

        //Terminate connection
        s1in.close();
        s1out.close();
        s1.close();
        s.close();
	} 
}





// 