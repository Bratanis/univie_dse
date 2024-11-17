package messageV3;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Arrays;

public class Message implements UDPMessage{
	// private static final long serialVersionUID = -1882656973952573394L;
	public static final int MAX_PACKAGE_SIZE = 65487; // Since the packages will not be sent over the internet,
													   // we can set a realtively high payload size. Otherwise it 
													   // might make sense to keep the payload below 1,472 B!
    private byte[] dataBlob;
	private Integer num;
    private String senderName;
    private long timestampInMillis;

   /** 
    * @param clientInt
    * @param senderName
    */
    public Message(int blobSize, Integer clientInt, String senderName) {
    	// Will create a Message with an empty blob (will get filled by the other ctor!)
        this(new byte[blobSize], clientInt, senderName, System.currentTimeMillis());
    }
    
    public Message(byte[] dataBlob, Integer clientInt, String senderName, long timestampInMillis) {
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
 
    public int getMessageSize() {
        byte[] senderNameBytes = getSenderNameBytes(); 
    	return (Integer.BYTES + Long.BYTES + Integer.BYTES + senderNameBytes.length
        				+ Integer.BYTES + dataBlob.length);
    }
    
    private byte[] getSenderNameBytes () {
    	return senderName.getBytes(StandardCharsets.UTF_8);
    }
  
    public ByteBuffer[] serialize() {
    	byte[] senderNameBytes = getSenderNameBytes();
        int totalSize = getMessageSize();
        
        ByteBuffer buffer = ByteBuffer.allocate(totalSize);
        buffer.putInt(num);
        buffer.putLong(timestampInMillis);
        buffer.putInt(senderNameBytes.length); // Needed for deserialization
        buffer.put(senderNameBytes);

        buffer.putInt(dataBlob.length);
        buffer.put(dataBlob);
        
        buffer.flip(); // Prepare the buffer for reading 
        return new ByteBuffer[] {buffer};
    }
    
    public static Message deserialize(ByteBuffer[] buffers) {
    	ByteBuffer buffer = buffers[0];
    	Integer num = buffer.getInt();
    	long timestampInMillis = buffer.getLong();
    	
        int senderNameLength = buffer.getInt(); 
        byte[] senderNameBytes = new byte[senderNameLength];
        buffer.get(senderNameBytes); // Read the number of bytes needed for the sender name
        String senderName = new String(senderNameBytes, StandardCharsets.UTF_8);

        int dataBlobLength = buffer.getInt();
        byte[] dataBlob = new byte[dataBlobLength];
        buffer.get(dataBlob);
        
        return new Message(dataBlob, num, senderName, timestampInMillis);
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
