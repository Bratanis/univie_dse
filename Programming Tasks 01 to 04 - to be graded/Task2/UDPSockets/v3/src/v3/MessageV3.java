package v3;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Arrays;

// Largely reused TCP implementation code (my own)
public class MessageV3 implements Serializable{
	private static final long serialVersionUID = -1882656973952573394L;
    private byte[] dataBlob;
	private Integer num;
    private String senderName;
    private long timestampInMillis;

   /** 
    * @param clientInt
    * @param senderName
    */
    public MessageV3(int blobSize, Integer clientInt, String senderName) {
    	// Will create a Message with an empty blob (will get filled by the other ctor!)
        this(new byte[blobSize], clientInt, senderName, System.currentTimeMillis());
    }
    
    public MessageV3(byte[] dataBlob, Integer clientInt, String senderName, long timestampInMillis) {
    	if (dataBlob.length == 0) {
    		Arrays.fill(dataBlob, (byte) 0x98);	//Fills blob with an arbitrary hexadecimal number
    	} else {
    		this.dataBlob = dataBlob;
    	}
        this.num = clientInt;
        this.senderName = senderName;
        this.timestampInMillis = timestampInMillis;
    }
    
    public void incrementNum() {
    	++num;
    }
    
    //used to update the time stamp of the message to the current time
    public void updateTimestamp() {
    	this.timestampInMillis = System.currentTimeMillis();
    }

  
    public ByteBuffer serialize() {
        byte[] senderNameBytes = senderName.getBytes(StandardCharsets.UTF_8);
        int totalSize = Integer.BYTES + Long.BYTES + Integer.BYTES + senderNameBytes.length
        				+ Integer.BYTES + dataBlob.length;
        
        ByteBuffer buffer = ByteBuffer.allocate(totalSize);
        buffer.putInt(num);
        buffer.putLong(timestampInMillis);
        buffer.putInt(senderNameBytes.length); // Needed for deserialization
        buffer.put(senderNameBytes);

        buffer.putInt(dataBlob.length);
        buffer.put(dataBlob);
        
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

        int dataBlobLength = buffer.getInt();
        byte[] dataBlob = new byte[dataBlobLength];
        buffer.get(dataBlob);
        
        return new MessageV3(dataBlob, num, senderName, timestampInMillis);
    }
    
    
    //Ensures that the message-objects can be printed to the console
    @Override
    public String toString() {
        // Convert time stamp to a human-readable date and time format
        Timestamp formattedTimestamp = new Timestamp (timestampInMillis);
    	
        return "Message[" + "number: " + num +
        		"; size of data: " + dataBlob.length + " Bytes" +
        		";  sent by: " + senderName + 
        		";  at: " + formattedTimestamp +']';
    }

	public long getTimestampInMillis() {
		return timestampInMillis;
	}
}
