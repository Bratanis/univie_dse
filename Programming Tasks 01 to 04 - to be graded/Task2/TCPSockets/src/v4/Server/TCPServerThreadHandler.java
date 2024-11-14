package v4.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TCPServerThreadHandler {
	
	int threadCount;
	int totalIterations;
	//listening socket
	ServerSocket s;
	
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
		//Register service
		this.s = new ServerSocket(1254);
		logger.info("Server listening!");
	}
	
	public void toggle() throws IOException {
		for (int i = 0; i < threadCount; ++i) {
			
			TCPServerMsgReceiver serverRunnable = new TCPServerMsgReceiver(s, totalIterations/threadCount);
			Thread msgHandler = new Thread(serverRunnable);
			msgHandler.start();
			
			
			}
	}
	
}








