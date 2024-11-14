package copier;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
import customQueues.NoDuplicateNumbersPriorityBlockingQueue;
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
		// We want to proceed only with unique values
		this.printOutputQueue = new NoDuplicateNumbersPriorityBlockingQueue(); 
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
	

	@Override
	public void run() {
		
		//Debugging_____________________________________________________________
    	logger.info("Copy thread has been started");
		
    	//Debugging_____________________________________________________________
    	logger.info("Copying of elements will be attempted: " + !inputQueue.isEmpty());
    	
		while(true) {
			
			if(!inputQueue.isEmpty()) {
			
				Integer el = inputQueue.poll();
				
				try {
					multBy2outputQueue.put(el);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					multBy3outputQueue.put(el);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					multBy5outputQueue.put(el);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				try {
					printOutputQueue.put(el);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			    	//Debugging_____________________________________________________________
			    	logger.info("a copy cycle has been completed!");
			}
			
			
	    	
			try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
