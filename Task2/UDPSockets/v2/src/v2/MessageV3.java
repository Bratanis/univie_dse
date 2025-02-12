package v2;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

// Largely reused TCP implementation code (my own)
public class MessageV3 implements Serializable{
	private static final long serialVersionUID = -1882656973952573394L;
	private Integer num;
    private String senderName;
    private long timestampInMillis;

   /** 
    * @param clientInt
    * @param senderName
    */
    public MessageV3(Integer clientInt, String senderName) {
        this(clientInt, senderName, System.currentTimeMillis());
    }
    
    public MessageV3(Integer clientInt, String senderName, long timestampInMillis) {
        this.num = clientInt;
        this.senderName = senderName;
        this.timestampInMillis = timestampInMillis;
    }
    
    public void incrementNum() {
    	++num;
    }
  
    public ByteBuffer serialize() {
        byte[] senderNameBytes = senderName.getBytes(StandardCharsets.UTF_8);
        int totalSize = Integer.BYTES + Long.BYTES + Integer.BYTES + senderNameBytes.length;
        
        ByteBuffer buffer = ByteBuffer.allocate(totalSize);
        buffer.putInt(num);
        buffer.putLong(timestampInMillis);
        buffer.putInt(senderNameBytes.length); // Needed for deserialization
        buffer.put(senderNameBytes);
        
        buffer.flip(); // Prepare the buffer for reading 
        return buffer;
    }
    
    public static MessageV3 deserialize(ByteBuffer buffer) {
    	Integer num = buffer.getInt();
    	long timestampInMillis = buffer.getLong();
        int senderNameLength = buffer.getInt(); 
        
        byte[] senderNameBytes = new byte[senderNameLength];
        buffer.get(senderNameBytes); // Read the number of bytes needed for the sender name
        String senderName = new String(senderNameBytes, StandardCharsets.UTF_8);
        
        return new MessageV3(num, senderName, timestampInMillis);
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
