package v4Server;
import java.io.IOException;



//Task 2.4______________________________________________________________________________________
public class TCPServer_v4 {


public static void main(String[] args) throws IOException, ClassNotFoundException{
	
	int numOfBlobSizes = 6;
	
	int iterationsPerBlobSize = 1000;
	
	//Number of threads that will send messages in parallel
	int threadCount = 4;
	
		TCPServerThreadHandler threadHandler = new TCPServerThreadHandler(threadCount, numOfBlobSizes * iterationsPerBlobSize);
		
		threadHandler.toggle();
	}
}
