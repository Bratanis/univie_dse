package v4.v4Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import v4.Message_v4;

public class TCPServerMsgReceiver implements Runnable{

	ServerSocket s;
	int iterations;
	
	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(TCPServer_v4.class.getName());
	static {
		Logger.getLogger("TCPServer_v4").setLevel(Level.WARNING);
	}
	
	public TCPServerMsgReceiver (ServerSocket s, int iterations) {
		this.s = s;
		this.iterations = iterations;
	}
	
	@Override
	public void run() {
		try {
				//Wait and accept connection (in another socket)
				Socket s1;
				s1 = s.accept();
				logger.info("Connection established!");
				
				//Create input and output communication streams
			    ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
			    ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
			    
			    //loop that will accept, increment and return 6000 messages 
			    //(1000 for each the 6 different dataBlob sizes )
			    for (int i = 0; i < iterations; ++i) {
				    //Read integer from client
				    Message_v4 receivedMsg = (Message_v4) ois.readObject();
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
		} catch (IOException e) {
			logger.warning("Connection could not be established!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.warning("Class Message_v4 could not be found!");
			e.printStackTrace();
		}
	}

}
