package v4.v4Server;
import java.io.IOException;



//Task 2.4______________________________________________________________________________________
public class TCPServer_v4 {


public static void main(String[] args) throws IOException, ClassNotFoundException{
	
		TCPServerThreadHandler threadHandler = new TCPServerThreadHandler(4, 6000);
		
		threadHandler.toggle();
	}
}
