import java.io.Serializable;
import java.sql.Timestamp;


//Task 2.2______________________________________________________________________________________
public class Message_v2 implements Serializable{
	private static final long serialVersionUID = -1882656973952573394L;
	private int num;
    private String senderName;
    private long timestampInMillis;

    
    public Message_v2(Integer clientInt, String senderName) {
        this.num = clientInt;
        this.senderName = senderName;
        this.timestampInMillis = System.currentTimeMillis();
    }
    
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
