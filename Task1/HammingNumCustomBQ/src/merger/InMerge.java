package merger;
import java.util.concurrent.BlockingQueue;
import customQueues.CustomPriorityBlockingQueue;
import customQueues.NoDuplicateNumbersPriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import mutiplyer.MultBy2;
import mutiplyer.MultBy3;
import mutiplyer.MultBy5;



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
    	// Will wait for all of the input queues to provide an element before proceeding
    	this.sortedOutputQueue = new NoDuplicateNumbersPriorityBlockingQueue();
    	//this.sortedOutputQueue = new CustomPriorityBlockingQueue();
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
		        try {
					sortedOutputQueue.put(multBy2inputQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					sortedOutputQueue.put(multBy3inputQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					sortedOutputQueue.put(multBy5inputQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	        try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
    
    
}
