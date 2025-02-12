package v4Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TCPServerThreadHandler {
	
	int threadCount;
	int totalIterations;
	//listening socket
	ServerSocket listeningSocket;
	Thread[] clientConnections;
	
	//For Debugging_________________________________
	private static final Logger logger = Logger.getLogger(TCPServer_v4.class.getName());
	static {
		Logger.getLogger("TCPServer_v4").setLevel(Level.WARNING);
	}
	
	/**
	 * @threadCount: number of threads that should establish connections to clients
	 * @totalIterations: the number of messages that should be handled by the threads
	 * */
	public TCPServerThreadHandler(int threadCount, int totalIterations) throws IOException {
		this.threadCount = threadCount;
		this.totalIterations = totalIterations;
		this.clientConnections = new Thread[threadCount];
		//Register service
		this.listeningSocket = new ServerSocket(1260);
		logger.info("Server listening!");
	}
	
	public void toggle() throws IOException {
		for (int i = 0; i < threadCount; ++i) {
			Socket clientSocket = listeningSocket.accept();
			TCPServerMsgReceiver serverRunnable = new TCPServerMsgReceiver(clientSocket, totalIterations/threadCount);
			Thread msgHandler = new Thread(serverRunnable);
			this.clientConnections[i] = msgHandler;
			msgHandler.start();
		}
		
		// When all threads are finished, close the listening socket:
		for (Thread thread : clientConnections) {
			try {
		        thread.join(); // Wait for the thread to finish
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		
		listeningSocket.close();
	}
	
}








