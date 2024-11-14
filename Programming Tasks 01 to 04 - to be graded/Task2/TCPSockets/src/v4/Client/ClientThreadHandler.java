package v4.Client;

import java.io.IOException;
import java.util.Arrays;

/**
 * Encapsulates the entire multi-threaded message sending process.
 * Can be called with any parameters (that fit the ctor-format, thus making it flexible.
 * The only method that can be called from outside (other than the ctor) are the "print" method and the "toggle" method.
 * The latter starts sending the messages in a multi-threaded fashion.
 * */
public class ClientThreadHandler {

	
	
	//An array containing different blob sizes in Bytes
	int[] blobSizes;
	
	//Number of times the message will be "ping-ponged" between client and server for each blob size
	int totalIterations;
	
	//Number of threads that will send messages in parallel
	int threadCount;
	
	//An array to store references to the threads
	Thread[] msgSenderThreads = new Thread[threadCount];
		
	//An array to store references to average transmission times array for ever thread (array of arrays)
	long[][] allThreadsAvgTTs = new long[threadCount][];
	
	public ClientThreadHandler(int[] blobSizes, int totalIterations, int threadCount) {
		this.blobSizes = blobSizes;
		this.totalIterations = totalIterations;
		this.threadCount = threadCount;
	}
	
	
	/**
	 * Starts the pre-defined number of threads and makes sure they are finished before moving on
	 * @throws IOException 
	 **/
	public void toggle() throws IOException {
		for (int i = 0; i < threadCount; ++i) {
			
			TCPClientMsgSender msgSenderRunnable = new TCPClientMsgSender(i, blobSizes, totalIterations/threadCount);
			Thread msgSender = new Thread(msgSenderRunnable);
			msgSender.start();
			msgSenderThreads[i] = msgSender;
			allThreadsAvgTTs[i] = msgSenderRunnable.getAvgTransmissionTimes();
			
		}
		
		//Wait for threads to finish its execution
		for (Thread thread : msgSenderThreads) {
		    try {
		        thread.join(); // Wait for the thread to finish
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	private long[] getTotalAverageTransmissionTimes() {
		long[] res = new long[blobSizes.length];
		Arrays.fill(res, 0);
		int i = 0;
		for (long[] oneThreadAvgTT : allThreadsAvgTTs) {
			res[i] = oneThreadAvgTT[i];
			++i;
		}
		for (long avgTT : res) {
			avgTT = avgTT/threadCount;
		}
		return res;
	}
	
	public void printAvgTT() {
		{
			long[] avgTransmissionTimes = getTotalAverageTransmissionTimes();
			for (int i = 0; i < blobSizes.length; ++i) {
				System.out.println("Messaage with a blob of size:" + blobSizes[i]
								   + "B have an average roundtrip transmission time of:"
								   + avgTransmissionTimes[i] + "ms.");
			}
		}
	}
}








