package v4;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;


//Task 2.4______________________________________________________________________________________
public class Message_v4 implements Serializable{
	private static final long serialVersionUID = -1688826892073466856L;
	private int num;
    private String senderName;
    private long timestampInMillis;
    private byte[] dataBlob;

    
    public Message_v4(Integer clientInt, String senderName, int blobSize) {
        this.num = clientInt;
        this.senderName = senderName;
        this.timestampInMillis = System.currentTimeMillis();
        updateTimestamp();
        this.dataBlob = new byte[blobSize];
        Arrays.fill(dataBlob, (byte) 0x98);	//Fills blob with an arbitrary hexadecimal number
    }
    
    //used to calculate round trip time for the message
    public long getTimestampInMillis() {
		return timestampInMillis;
	}
    
    //used to update the time stamp of the message to the current time
    public void updateTimestamp() {
    	this.timestampInMillis = System.currentTimeMillis();
    }

    //called by the server
	public void incrementNum() {
    	++num;
    }
    
    //Ensures that the message-objects can be printed to the console
    @Override
    public String toString() {
        // Convert time stamp to a human-readable date and time format
        Timestamp formattedTimestamp = new Timestamp (timestampInMillis);
    	
        return "Message[" + "number: " + num +
        		";  sent by: " + senderName + 
        		";  at: " + formattedTimestamp +']';
    }
}
