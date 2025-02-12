import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


//Task 2.2______________________________________________________________________________________
public class TCPClient_v2 {

public static void main(String[] args) throws IOException, ClassNotFoundException {
		
	  //Message, containing an integer that will be incremented by the server
	  Message_v2 clientMsg = new Message_v2(5, "client1");	
		
      //Open connection to a server, at port 1254
      Socket s1 = new Socket("localhost", 1254);
      
      //Create input and output communication streams
      ObjectOutputStream oos = new ObjectOutputStream(s1.getOutputStream());
      ObjectInputStream ois = new ObjectInputStream(s1.getInputStream());
      
      //Sending
      oos.writeObject(clientMsg);
      oos.flush();
      
      //Receiving
      Message_v2 receivedMsg = (Message_v2) ois.readObject();
      
      //Print to the console
      System.out.println("The server returns: " + receivedMsg);
      
      //Terminate connection
      oos.close();
      ois.close();
      s1.close();
  }
}
