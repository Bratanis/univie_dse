import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Print implements Runnable{
	
	//Debugging_____________________________________________________________
	private static final Logger logger = Logger.getLogger(Print.class.getName());
	
	static {
        Logger.getLogger("Print").setLevel(Level.OFF);
    }
	
	//keeps track of how many numbers are printed
	private static int printNumberCount = 0;
	private static int maxPrintNumberCount = 1; //Default value

	BlockingQueue<Integer> inputQueue;
	
////////////////////////////////////////////////////////////////////	
	
	public Print(Copy copy){
		this.inputQueue = copy.getPrintOutputQueue();
	}
	
	
	//Used to detect when to stop the algorithm
	public static void setMaxPrintCount(int maxCount) {
		Print.maxPrintNumberCount = maxCount;
	}
	

	public boolean requestedOutputReached() {
		return (printNumberCount >= maxPrintNumberCount);
	}
	
	@Override
	public void run() {
		
		//Debugging_____________________________________________________________
    	logger.info("Print thread has been started");
		
		while(!requestedOutputReached()) {
			
			if(!inputQueue.isEmpty()) {				
				//Debugging_____________________________________________________________
				logger.info("A number will be printed: ");
				
				System.out.println(inputQueue.poll());				
				++printNumberCount;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (requestedOutputReached()) {
            System.exit(0);
		}
		
	}

}
