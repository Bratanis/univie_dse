import java.util.Scanner;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import copier.Copy;
import merger.InMerge;
import mutiplyer.MultBy2;
import mutiplyer.MultBy3;
import mutiplyer.MultBy5;
import printer.Print;
import printer.PrintedNumbersCounter;

//
//
// Important: 
// Most of this code was written in SS24 by (me) Ivan Bratanov (12228892) 
// and is being reused with slight modifications in WS24
//
// Analysis on the task can be found in the README file.
//
//

public class Main {

	public static void main(String[] args) {

	Logger.getLogger("").setLevel(Level.OFF); // Logging not needed for the final version of the program 
    //Instantiate an object that will count the number of printed numbers
    PrintedNumbersCounter printedNumbersCounter = new PrintedNumbersCounter();

		//Runnables instantiated:
		MultBy2 multBy2 = new MultBy2();
		MultBy3 multBy3 = new MultBy3();
		MultBy5 multBy5 = new MultBy5();
		InMerge inMerge = new InMerge(multBy2, multBy3, multBy5);
		Copy copy = new Copy(inMerge, multBy2, multBy3, multBy5);
		Print print = new Print(copy, printedNumbersCounter);
		
		//Instantiate threads
		Thread multBy2Thread = new Thread(multBy2);
		Thread multBy3Thread  = new Thread(multBy3);
		Thread multBy5Thread  = new Thread(multBy5);
		Thread copyThread = new Thread(copy);
		Thread inMergeThread = new Thread(inMerge);
		Thread printThread = new Thread(print);

    //Ask user how many numbers they want
    System.out.print("Please enter how many numbers you want: ");
    Scanner scanner = new Scanner(System.in);
    int maxCount = (scanner.nextInt());
    scanner.close();
    System.out.println("Hamming numbers: ");
    
    //set the amount of numbers to be generated and initialize the copy queue:
    printedNumbersCounter.setMaxPrintCount(maxCount);
    copy.toggleGeneration();
    
    //Start threads
    multBy2Thread.start();
    multBy3Thread.start();
    multBy5Thread.start();
    copyThread.start();
    inMergeThread.start();
    printThread.start();

	}
}














