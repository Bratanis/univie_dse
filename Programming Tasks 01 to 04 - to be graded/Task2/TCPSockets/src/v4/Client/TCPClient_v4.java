package v4.Client;
import java.io.IOException;


//Task 2.4______________________________________________________________________________________
public class TCPClient_v4 {

	
	
public static void main(String[] args) throws IOException, ClassNotFoundException {
	
	//An array containing different blob sizes in Bytes 
	int[] blobSizes = {1024, 2048, 4096, 8192, 16384, 131072};
	
	//Number of times the message will be "ping-ponged" between client and server for each blob size
	int totalIterations = 1000;
	
	//Number of threads that will send messages in parallel
	int threadCount = 4;
	
	ClientThreadHandler mtMessageHandler = new ClientThreadHandler(blobSizes, totalIterations, threadCount);
      
	mtMessageHandler.toggle();
	
	mtMessageHandler.printAvgTT();

  }
}


//An array to store references to the runnables
//

//	//Iterate through the blobSize array, sending 1000 messages for each blob size
//	for(int i = 0; i < blobSizes.length; ++i) {
//		
//		  //Array where the time stamps of the messages will be saved, unique for every blobSize
//		  //Used to compute the average transmission time of the message
//		  long[] receivedMsgTimestamps = new long[iterations]; 
//		
//		  //Message, containing an integer that will be incremented by the server
//		  Message_v4 clientMsg = new Message_v4(0, "client1", blobSizes[i]);	
//			
//		  //Send the message to the server, then keep sending the received (from the server) 
//		  //message for the given number of iterations
//		  for (int j = 0; j < iterations; ++j) {
//		      //Sending
//		      oos.writeObject(clientMsg);
//		      oos.flush();
//		      
//		      //Receiving
//		      Message_v4 receivedMsg = (Message_v4) ois.readObject();
//		      
//		      //Saving time stamp
//		      receivedMsgTimestamps[j] = receivedMsg.getTimestampInMillis();
//		      
//		      //updating the time stamp and preparing the message to be sent again
//		      receivedMsg.updateTimestamp();
//		      clientMsg = receivedMsg;
//		  }
//		  
//		  //calculate the average round trip time for the blob size and add it to the respective array
//		  avgTransmissionTimes[i] = getAvgTransmissionTime(receivedMsgTimestamps);
//	}