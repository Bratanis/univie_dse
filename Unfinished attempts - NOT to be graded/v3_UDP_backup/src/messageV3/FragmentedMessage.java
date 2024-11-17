package messageV3;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class FragmentedMessage implements UDPMessage{

	private Message messageHead; // the original message
	private List<BlobFragment> fragments; // the same message, broken down into transportable chunks

    public FragmentedMessage(int blobSize, Integer clientInt, String senderName) {
    	// Will create a Message with an empty blob (will get filled by the other ctor!)
        this(new byte[blobSize], clientInt, senderName, System.currentTimeMillis());
    }
    
	public FragmentedMessage(byte[] dataBlob, Integer clientInt, String senderName, long timestampInMillis) {
    	assert (dataBlob.length > Message.MAX_PACKAGE_SIZE);
    	byte[] emptyHeadBlob = {0};
		this.messageHead = new Message(emptyHeadBlob, clientInt, senderName, timestampInMillis);
		fragmentData(dataBlob);
	}

	private void fragmentData(byte[] dataBlob) {
		int totalNumOfFragments = (int) Math.ceil((double) dataBlob.length / Message.MAX_PACKAGE_SIZE);
        for (int i = 0; i < totalNumOfFragments; i++) {
            int start = i * Message.MAX_PACKAGE_SIZE;
            int end = Math.min(start + Message.MAX_PACKAGE_SIZE,  dataBlob.length );
            byte[] fragmentData = new byte[end - start];
            System.arraycopy(dataBlob, start, fragmentData, 0, fragmentData.length);
            fragments.add(new BlobFragment(i, totalNumOfFragments, fragmentData));
        }
	}

	@Override
	public ByteBuffer[] serialize() {
		ArrayList<ByteBuffer> res = new ArrayList();
		ByteBuffer serializedHead = (messageHead.serialize())[0];
		res.add(serializedHead);
		for (BlobFragment blobFragment : fragments) {
			res.add(blobFragment.serialize());
		}
		return (ByteBuffer[]) res.toArray();
	}
	
	
	public static FragmentedMessage deserialize(ByteBuffer[] buffers) {
		return null;
		
	}
	
	@Override
	public void incrementNum() {
		messageHead.incrementNum();
		
	}
	@Override
	public void updateTimestamp() {
		messageHead.updateTimestamp();
	}
}
