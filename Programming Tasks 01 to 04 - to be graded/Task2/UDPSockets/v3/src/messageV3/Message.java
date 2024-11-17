package messageV3;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Message {
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
    
    public final boolean shouldBeFragmented() {
    	return dataBlob.length > Message.MAX_PACKAGE_SIZE;
    }

    public final boolean isComplete() {
    	return (dataBlob.length != 0);
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
  
    public ByteBuffer serialize() {
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
        return buffer;
    }
    
    public List<ByteBuffer> serializeLargeMessage() {
    	
    	List<ByteBuffer> buffers = new ArrayList(); // Create the list
    	
    	Message messageHead = getMessageHead(); // Get the message head (no datablob)
    	DataFragment headFragment = new DataFragment(0, getTotalNumOfFragments(), messageHead.serialize().array());
    	
    	buffers.add(messageHead.serialize()); // Put it in the list
    	
    	List<DataFragment> blobFragments = getBlobFragments();
    	for (DataFragment fragment : blobFragments) {
    		ByteBuffer serializedBlobFragment = fragment.serialize();
    		buffers.add(serializedBlobFragment);
    	}
    	
    	return buffers;
    }
    
    private Message getMessageHead() {
    	byte[] emptyHeadBlob = {};
    	return new Message (emptyHeadBlob, this.num, this.senderName, this.timestampInMillis);
    }
    
    private int getTotalNumOfFragments() {
    	return ((int) Math.ceil((double) dataBlob.length / Message.MAX_PACKAGE_SIZE) + 1); // adding 1 for the header fragment (not in the dataBlob)
    }
    
    private List<DataFragment> getBlobFragments(){
    	
    	assert (dataBlob.length > Message.MAX_PACKAGE_SIZE); // Make sure the method is being called properly
    	
    	List<DataFragment> fragments = new ArrayList(); 
    	
    	int totalNumOfFragments = getTotalNumOfFragments();
        for (int i = 0; i < totalNumOfFragments; i++) {
            int start = i * Message.MAX_PACKAGE_SIZE;
            int end = Math.min(start + Message.MAX_PACKAGE_SIZE,  dataBlob.length );
            byte[] fragmentData = new byte[end - start];
            System.arraycopy(dataBlob, start, fragmentData, 0, fragmentData.length);
            fragments.add(new DataFragment(i + 1, totalNumOfFragments, fragmentData)); // Fragments are i+1 because the index 0 is reserved for the header!
        }
        return fragments;
    }
    
    public static Message deserialize(ByteBuffer buffer) {
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
    
    public static Message deserializeLargeMessage(List<ByteBuffer> buffers) {
    	// First we convert all of the buffers to DataFragments and extract the header
    	List<DataFragment> blobFragments = new ArrayList();
    	ByteBuffer serializedMessageHeader = null; // Must implement checks if the header is found
    	for (ByteBuffer buffer : buffers) {
    		DataFragment deserializedFragment = DataFragment.deserialize(buffer);
    		if (deserializedFragment.getFragmentNumber() == 0)
                serializedMessageHeader = ByteBuffer.wrap(deserializedFragment.getFragmentData());
    		else
    			blobFragments.add(deserializedFragment);
    	}
    	
    	// Make sure the header is present
    	if (serializedMessageHeader == null) {
    		throw new IllegalArgumentException ("couldn't deserialize large message - header lost!");
    	}
    	Message headerMessage = Message.deserialize(serializedMessageHeader);
    	
    	// After that we assemble the datablob
    	byte[] dataBlob = reassembleDataBlob(blobFragments);
        
        Message assembledMessage = new Message(headerMessage, dataBlob);
        
        return assembledMessage;
    }

    private static byte[] reassembleDataBlob(List<DataFragment> blobFragments) {
    	
    	// First we sort the fragments:
        blobFragments.sort((bf1, bf2) -> Integer.compare(bf1.getFragmentNumber(), bf2.getFragmentNumber()));
        
        // Then we combine the data blob fragments
        List<Byte> dataBlobList = new ArrayList();
        for (DataFragment fragment : blobFragments) {
            for (byte b : fragment.getFragmentData()) {
                dataBlobList.add(b);
            }
        }
        byte[] dataBlob = new byte[dataBlobList.size()];
        for (int i = 0; i < dataBlobList.size(); i++) {
            dataBlob[i] = dataBlobList.get(i);  
        }
        
        return dataBlob;
    }
    
    private Message (Message headerMessage, byte[] dataBlob) {
    	this(dataBlob, headerMessage.num, headerMessage.senderName, headerMessage.getTimestampInMillis());
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
