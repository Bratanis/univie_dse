package v4Client;

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
	Thread[] msgSenderThreads;
	
	Runnable[] msgSenderRunnables;
		
	//An array to store references to average transmission times array for ever thread (array of arrays)
	// Rows will be the different threads, columns will be the different blob sizes
	long[][] allThreadsAvgTTs;
	
	public ClientThreadHandler(int[] blobSizes, int totalIterations, int threadCount) {
		this.blobSizes = blobSizes;
		this.totalIterations = totalIterations;
		this.threadCount = threadCount;
		this.msgSenderRunnables = new Runnable[threadCount];
		this.msgSenderThreads = new Thread[threadCount];
		this.allThreadsAvgTTs = new long[threadCount][];

	}
	
	
	/**
	 * Starts the pre-defined number of threads and makes sure they are finished before moving on
	 * @throws IOException 
	 **/
	public void toggle() throws IOException {
		for (int threadIndex = 0; threadIndex < threadCount; ++threadIndex) {
			
			TCPClientMsgSender msgSenderRunnable = new TCPClientMsgSender(threadIndex, blobSizes, totalIterations/threadCount);
			this.msgSenderRunnables[threadIndex] = msgSenderRunnable;
			Thread msgSender = new Thread(msgSenderRunnable);
			msgSenderThreads[threadIndex] = msgSender;
			msgSender.start();
//			allThreadsAvgTTs[threadIndex] = msgSenderRunnable.getAvgTransmissionTimes();
			
		}
		
		//Wait for threads to finish its execution
		for (Thread thread : msgSenderThreads) {
		    try {
		        thread.join(); // Wait for the thread to finish
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		// Get the average transmission times after all threads have completed
	    for (int i = 0; i < msgSenderRunnables.length; ++i) {
	        allThreadsAvgTTs[i] = ((TCPClientMsgSender) msgSenderRunnables[i]).getAvgTransmissionTimesForEachBlobSize();
	    }
	}
	
	private long[] getTotalAverageTransmissionTimes() {
		// each entry in the res array will be the avg transmission time of the blob size with the same index
		long[] avgTTForEachBlobSize = new long[blobSizes.length]; 
		// initialize the array with zeroes
		Arrays.fill(avgTTForEachBlobSize, 0);	
		
		for (int threadNum = 0; threadNum < this.threadCount; threadNum++) {
			for (int blobSizeNum = 0; blobSizeNum < blobSizes.length; blobSizeNum++) {
				
				avgTTForEachBlobSize[blobSizeNum] += allThreadsAvgTTs[threadNum][blobSizeNum]; 
				
			}
		}
		
		for (long avgTT : avgTTForEachBlobSize) {
			avgTT = avgTT/threadCount;
		}
		return avgTTForEachBlobSize;
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








