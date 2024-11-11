package copier;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import merger.InMerge;
import mutiplyer.MultBy2;
import mutiplyer.MultBy3;
import mutiplyer.MultBy5;

public class Copy implements Runnable{
	
	//Debugging_____________________________________________________________
	private static final Logger logger = Logger.getLogger(Copy.class.getName());
	  
	static {
	  Logger.getLogger("Copy").setLevel(Level.OFF);
  }

	BlockingQueue<Integer> inputQueue;
	
	BlockingQueue<Integer> multBy2outputQueue;
  BlockingQueue<Integer> multBy3outputQueue;
  BlockingQueue<Integer> multBy5outputQueue;
  BlockingQueue<Integer> printOutputQueue;

    
    
////////////////////////////////////////////////////////////////////
	
    //Ctor takes in the three multiplier threads so that it can insert element into them
    //the inputQueue is empty at the beginning and gets initialized manually (toggleGeneration())!
	public Copy(InMerge inMerge, MultBy2 multBy2, MultBy3 multBy3, MultBy5 multBy5){
		
		this.inputQueue = inMerge.getSortedOutputQueue();
		
		this.multBy2outputQueue = multBy2.getInputQueue();
		this.multBy3outputQueue = multBy3.getInputQueue();
		this.multBy5outputQueue = multBy5.getInputQueue();
		this.printOutputQueue = new PriorityBlockingQueue<>();
	}
	
	//for forwarding the queue to the Print class
	public BlockingQueue<Integer> getPrintOutputQueue() {
		return printOutputQueue;
	}
	
	public void toggleGeneration() {
		if (inputQueue.isEmpty()) {
			inputQueue.offer(1);
		}
	}
	
  //______________________________________________________________________-> probably should be implemented in the InMerge so that duplicates are removed on time
	// Check if the inMerge queue has duplicate elements and skip them
	private void skipDuplicatesOf (Integer el) {
		if (inputQueue.peek() != null && el == inputQueue.peek()) {
			inputQueue.poll();
		}
	}

	@Override
	public void run() {
		
		//Debugging_____________________________________________________________
    	logger.info("Copy thread has been started");
		
    	//Debugging_____________________________________________________________
    	logger.info("Copying of elements will be attempted: " + !inputQueue.isEmpty());
    	
		while(true) {
			
			if(!inputQueue.isEmpty()) {
			
				Integer el = inputQueue.poll();
				
				// Check if the inMerge queue has duplicate elements and skip them
				skipDuplicatesOf(el);
				
				if(multBy2outputQueue.offer(el)) {
					//Debugging_____________________________________________________________
			    	logger.info(el +" has been copied to multBy2outputQueue");
				} else {
		        	logger.severe("Element NOT copied to multBy2outputQueue !!!");
		        }
				if(multBy3outputQueue.offer(el)) {
					//Debugging_____________________________________________________________
			    	logger.info(el +" has been copied to multBy3outputQueue");
				} else {
		        	logger.severe("Element NOT copied to multBy3outputQueue !!!");
		        }
				if(multBy5outputQueue.offer(el)) {
					//Debugging_____________________________________________________________
			    	logger.info(el +" has been copied to multBy5outputQueue");
				} else {
		        	logger.severe("Element NOT copied to multBy5outputQueue !!!");
		        }
				if(printOutputQueue.offer(el)) {
					//Debugging_____________________________________________________________
			    	logger.info(el +" has been copied to printOutputQueue");
				} else {
		        	logger.severe("Element NOT copied to printOutputQueue !!!");
		        }
			    	//Debugging_____________________________________________________________
			    	logger.info("a copy cycle has been completed!");
			}
			
			
	    	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
