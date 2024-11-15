package v1;
import java.net.*;
import java.io.*;


//Task 2.1______________________________________________________________________________________
public class TCPClient_v1 {

	public static void main(String[] args) throws IOException {
		
		//Integer that will be incremented by the server (develop user input later if time allows)
		int clientInt = 2;	
		
      //Open connection to a server, at port 1254
      Socket s1 = new Socket("localhost", 1254);
      
      //Create input and output communication streams
      DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
      DataInputStream dis = new DataInputStream(s1.getInputStream());
      
      //Send
      dos.writeInt(clientInt);
      
      //Receive
      int incrementedInt = dis.readInt();
      
      //Print to the console
      System.out.println("The server returns: " + incrementedInt);
      
      //Terminate connection
      dos.close();
      dis.close();
      s1.close();
  }
}



