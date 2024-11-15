import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


//Task 2.3______________________________________________________________________________________
public class TCPClient_v3 {

	private static long getAvgTransmissionTime(long[] receivedMsgTimestamps) {
		//Make sure there is a valid number of time stamps in the array
		if (receivedMsgTimestamps == null || receivedMsgTimestamps.length < 2) {
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
	
	private static void printTransmissionTimes(long[] avgTransmissionTimes, int[] blobSizes) {
		for (int i = 0; i < blobSizes.length; ++i) {
			System.out.println("Messaage with a blob of size:" + blobSizes[i]
							   + "B have an average roundtrip transmission time of:"
							   + avgTransmissionTimes[i] + "ms.");
		}
	}
	
public static void main(String[] args) throws IOException, ClassNotFoundException {
	
	//Open connection to a server, at port 1254
	Socket s1 = new Socket("localhost", 1234);
	
	//Create input and output communication streams
	ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
	ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
	
	//An array containing different blob sizes in Bytes 
	int[] blobSizes = {1024, 2048, 4096, 8192, 16384, 131072};
	
	//An array containing the average transmission time for every blob size
	long[] avgTransmissionTimes = new long[blobSizes.length];
	
	//Number of times the message will be "ping-ponged" between client and server for each blob size
	int iterations = 100;
	
	//Iterate through the blobSize array, sending 1000 messages for each blob size
	for(int i = 0; i < blobSizes.length; ++i) {
		
		  //Array where the time stamps of the messages will be saved, unique for every blobSize
		  //Used to compute the average transmission time of the message
		  long[] receivedMsgTimestamps = new long[iterations]; 
		
		  //Message, containing an integer that will be incremented by the server
		  Message_v3 clientMsg = new Message_v3(0, "client1", blobSizes[i]);	
			
		  //Send the message to the server, then keep sending the received (from the server) 
		  //message for the given number of iterations
		  for (int j = 0; j < iterations; ++j) {
		      //Sending
		      oos.writeObject(clientMsg);
		      oos.flush();
		      
		      //Receiving
		      Message_v3 receivedMsg = (Message_v3) ois.readObject();
		      
		      //Saving time stamp
		      receivedMsgTimestamps[j] = receivedMsg.getTimestampInMillis();
		      
		      //updating the time stamp and preparing the message to be sent again
		      receivedMsg.updateTimestamp();
		      clientMsg = receivedMsg;
		  }
		  
		  //calculate the average round trip time for the blob size and add it to the respective array
		  avgTransmissionTimes[i] = getAvgTransmissionTime(receivedMsgTimestamps);
	}
      
      //Print to the console
	  printTransmissionTimes(avgTransmissionTimes, blobSizes);
      
      //Terminate connection
      oos.close();
      ois.close();
      s1.close();
  }
}
