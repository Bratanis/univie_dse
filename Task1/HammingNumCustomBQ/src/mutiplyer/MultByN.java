package mutiplyer;
import java.util.concurrent.BlockingQueue;
import customQueues.CustomPriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class MultByN implements Runnable{
	
	//Debugging_____________________________________________________________
    private static final Logger logger = Logger.getLogger(MultByN.class.getName());
    static {
        Logger.getLogger("MultByN").setLevel(Level.OFF);
    }
	
	BlockingQueue<Integer> inputQueue;
    BlockingQueue<Integer> outputQueue;
	protected int N; // the integer the numbers will be multiplied by
	
////////////////////////////////////////////////////////////////////
	//The input and output queue get filled by other methods
	public MultByN() {
        this.inputQueue = new CustomPriorityBlockingQueue();
        this.outputQueue = new CustomPriorityBlockingQueue();
    }


	//Used to get the queue into the InMerge
	public BlockingQueue<Integer> getOutputQueue() {
		return outputQueue;
	}


	//Used to allow Copy to access the input queue
	public BlockingQueue<Integer> getInputQueue() {
		return inputQueue;
	}
	
	
	private void generateNumber() {
		
		//Debugging_____________________________________________________________
    	logger.info("Number generation will be attempted:" + !inputQueue.isEmpty());
    	
    	if (!inputQueue.isEmpty()) {					//if (inputQueue.peek() != null)
    		Integer newHammingNum = inputQueue.poll() * N;
        if	(outputQueue.offer(newHammingNum)){
          logger.info("MultBy" + N + " added " + newHammingNum + " to the output queue");
        }
      }
	}
	
	@Override
	public void run() {

    		//Debugging_____________________________________________________________
			logger.info("MultBy" + N + " thread has been started");
		
            while (true) {
            	
            	generateNumber();
            	
                try {
					Thread.sleep(000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
	}
}
