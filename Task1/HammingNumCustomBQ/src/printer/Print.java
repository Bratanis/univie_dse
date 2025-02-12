package printer;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import copier.Copy;
import customQueues.CustomPriorityBlockingQueue;
import merger.InMerge;

public class Print implements Runnable{
	
	//Debugging_____________________________________________________________
	private static final Logger logger = Logger.getLogger(Print.class.getName());

	private CustomPriorityBlockingQueue inputQueue;
  private PrintedNumbersCounter printedNumbersCounter;
	
////////////////////////////////////////////////////////////////////	
	
	public Print(Copy copy, PrintedNumbersCounter counter){
		this.inputQueue = (CustomPriorityBlockingQueue) copy.getPrintOutputQueue();
		this.printedNumbersCounter = counter;
		this.inputQueue.setMinCapacityBeforeRemoving(counter.getMaxPrintNumberCount()); 
	}
	
	
	@Override
	public void run() {
		
		//Debugging_____________________________________________________________
    	logger.info("Print thread has been started");
		
		while(true) {
			
			if(!inputQueue.isEmpty()) {				
				//Debugging_____________________________________________________________
				logger.info("A number will be printed: ");
				
				try {
					System.out.println(inputQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				printedNumbersCounter.incrementCounter();
			}

      //Terminate the threads whenever the requested output is reached
			if (printedNumbersCounter.requestedOutputReached()){
				System.exit(0);
			}
		}
	}

}
