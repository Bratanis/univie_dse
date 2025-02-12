package v4Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import v4Message.Message_v4;

public class TCPClientMsgSender implements Runnable{

	Socket s;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	//An array containing different blob sizes in Bytes 
	int[] blobSizes;
	
	//An array containing the average transmission time for every blob size
	long[] avgTransmissionTimesForEachBlobSize;
	
	//Number of times the message will be "ping-ponged" between client and server for each blob size
	int iterations;
	
	// Every Runnable of this class will be indexed to keep track of the number of threads. This index is the unique id of an objectj
	int threadIndex;
	
	
	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(TCPClientMsgSender.class.getName());
	static {
		Logger.getLogger("TCPClientMsgSender").setLevel(Level.WARNING);
	}
	
	/**
	 * TCPClientMsgSender requires oos, ois, int[] blobSizes, int iterations
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public TCPClientMsgSender(int threadNum, int[] blobSizes, int iterations) throws UnknownHostException, IOException {
		this.threadIndex = threadNum;
		//Open connection to a server
		this.s = new Socket("localhost", 1260);
		//Create input and output communication streams
		this.oos = new ObjectOutputStream(s.getOutputStream());
		this.ois = new ObjectInputStream(s.getInputStream());
		this.blobSizes=blobSizes;
		this.iterations=iterations;
		this.avgTransmissionTimesForEachBlobSize = new long[blobSizes.length];
	}
	
	
	//Helper functions
	private static long computeAvgTransmissionTimeForABlobSize(long[] receivedMsgTimestamps) {
		//Make sure there is a valid number of time stamps in the array
		if (receivedMsgTimestamps == null) {
			logger.severe("computeAvgTransmissionTimeForABlobSize() received an invalid array of timestamps (null)");
	        return 0;
	    }
		 
		if (receivedMsgTimestamps.length < 2) {
			logger.severe("computeAvgTransmissionTimeForABlobSize() received an invalid array of timestamps (length = " 
					+ receivedMsgTimestamps.length + ")!");
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
	
	
	public long[] getAvgTransmissionTimesForEachBlobSize() {
		return avgTransmissionTimesForEachBlobSize;
	}

	@Override
	public void run(){
		try {
			for(int i = 0; i < blobSizes.length; ++i) {
				
				  //Array where the time stamps of the messages will be saved, unique for every blobSize
				  //Used to compute the average transmission time of the message
				  long[] receivedMsgTimestampsForABlobSize = new long[iterations]; 
				
				  //Message, containing an integer that will be incremented by the server
				  Message_v4 clientMsg = new Message_v4(0, "client" + threadIndex, blobSizes[i]);	
					
				  //Send the message to the server, then keep sending the received (from the server) 
				  //message for the given number of iterations
				  for (int j = 0; j < iterations; ++j) {
				      //Sending
				      oos.writeObject(clientMsg);
				      oos.flush();
				      
				      //Receiving
				      Message_v4 receivedMsg = (Message_v4) ois.readObject();
				      
				      //Saving time stamp
				      receivedMsgTimestampsForABlobSize[j] = receivedMsg.getTimestampInMillis();
				      
				      //updating the time stamp and preparing the message to be sent again
				      receivedMsg.updateTimestamp();
				      clientMsg = receivedMsg;
				  }
				  
				  //calculate the average round trip time for the blob size and add it to the respective array
				  avgTransmissionTimesForEachBlobSize[i] = computeAvgTransmissionTimeForABlobSize(receivedMsgTimestampsForABlobSize);
				  
			}
			//Terminate connection
		      oos.close();
		      ois.close();
		      s.close();
		} catch (IOException | ClassNotFoundException e) {
			logger.severe("ClientRnnable could not connect to the server!");
			e.printStackTrace();
		}
	}
}
