public class PrintedNumbersCounter{

	//keeps track of how many numbers are printed
	private int printNumberCount = 0;
	private int maxPrintNumberCount = 0; //Default value

  
	//Used to detect when to stop the algorithm
	public void setMaxPrintCount(int maxCount) {
		maxPrintNumberCount = maxCount;
	}


	public boolean requestedOutputReached() {
		return (printNumberCount >= maxPrintNumberCount);
	}
	

  public void incrementCounter() {
    printNumberCount++;
  }
}
