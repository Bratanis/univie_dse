import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;



public class InMerge implements Runnable{
	
	//Debugging_____________________________________________________________
	private static final Logger logger = Logger.getLogger(InMerge.class.getName());
	
	static {
        Logger.getLogger("InMerge").setLevel(Level.OFF);
    }
	
	BlockingQueue<Integer> multBy2inputQueue;
    BlockingQueue<Integer> multBy3inputQueue;
    BlockingQueue<Integer> multBy5inputQueue;
    
    BlockingQueue<Integer> sortedOutputQueue;
    
////////////////////////////////////////////////////////////////////



	public InMerge(MultBy2 multBy2, MultBy3 multBy3, MultBy5 multBy5) {
    	this.multBy2inputQueue = multBy2.getOutputQueue();
    	this.multBy3inputQueue = multBy3.getOutputQueue();
    	this.multBy5inputQueue = multBy5.getOutputQueue();
    	
    	this.sortedOutputQueue = new PriorityBlockingQueue<>();
    }
    
	public BlockingQueue<Integer> getSortedOutputQueue() {
		return sortedOutputQueue;
	}
    
	@Override
	public void run() {
		
		//Debugging_____________________________________________________________
    	logger.info("InMerge thread has been started");
    	
		while(true) {

      boolean elementsShouldBeMerged = !multBy2inputQueue.isEmpty() && !multBy3inputQueue.isEmpty() && !multBy5inputQueue.isEmpty();

			//Debugging_____________________________________________________________
			logger.info("InMerge element manipulation will be attempted:" + (elementsShouldBeMerged));
			
			if(elementsShouldBeMerged) {

		        // Add all elements from the three queues to the priority queue
		        if(sortedOutputQueue.offer(multBy2inputQueue.poll())) {
		        	logger.info("Element moved from multBy2 queue to sortedOutputQueue");
		        } else {
		        	logger.severe("Element NOT moved from multBy2 queue to sortedOutputQueue !!!");
		        }
		        if(sortedOutputQueue.offer(multBy3inputQueue.poll())) {
		        	logger.info("Element moved from multBy3 queue to sortedOutputQueue");
		        } else {
		        	logger.severe("Element NOT moved from multBy3 queue to sortedOutputQueue !!!");
		        }
		        if(sortedOutputQueue.offer(multBy5inputQueue.poll())) {
		        	logger.info("Element moved from multBy5 queue to sortedOutputQueue");
		        } else {
		        	logger.severe("Element NOT moved from multBy5 queue to sortedOutputQueue !!!");
		        }
		        //Debugging_____________________________________________________________
		    	logger.info("InMerge element manipulation has been attempted");
			}
	        try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
    
    
}
