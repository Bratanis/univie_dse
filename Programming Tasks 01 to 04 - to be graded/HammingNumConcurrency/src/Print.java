import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Print implements Runnable{
	
	//Debugging_____________________________________________________________
	private static final Logger logger = Logger.getLogger(Print.class.getName());
	
	static {
        Logger.getLogger("Print").setLevel(Level.OFF);
    }
	
	private BlockingQueue<Integer> inputQueue;
  private PrintedNumbersCounter printedNumbersCounter;
	
////////////////////////////////////////////////////////////////////	
	
	public Print(Copy copy, PrintedNumbersCounter counter){
		this.inputQueue = copy.getPrintOutputQueue();
    this.printedNumbersCounter = counter;
	}
	
	
	@Override
	public void run() {
		
		//Debugging_____________________________________________________________
    	logger.info("Print thread has been started");
		
		while(true) {
			
			if(!inputQueue.isEmpty()) {				
				//Debugging_____________________________________________________________
				logger.info("A number will be printed: ");
				
				System.out.println(inputQueue.poll());				
				printedNumbersCounter.incrementCounter();
			}

      //Terminate the threads whenever the requested output is reached
      if (printedNumbersCounter.requestedOutputReached()){
        System.exit(0);
      }

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
