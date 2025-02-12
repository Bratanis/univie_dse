package messageV3;

import java.nio.ByteBuffer;

public class DataFragment {
	private int fragmentNumber;
    private int totalNumOfFragments;
    private byte[] fragmentData;

    public DataFragment(int fragmentNumber, int totalNumOfFragments, byte[] dataFragment) {
        this.fragmentNumber = fragmentNumber;
        this.totalNumOfFragments = totalNumOfFragments;
        this.fragmentData = dataFragment;
    }

    public int getFragmentNumber() {
        return fragmentNumber;
    }

    public int getTotalNumOfFragments() {
        return totalNumOfFragments;
    }

    public byte[] getFragmentData() {
        return fragmentData;
    }

	public ByteBuffer serialize() {
        int totalSize = Integer.BYTES + Integer.BYTES + Integer.BYTES + fragmentData.length;
        ByteBuffer buffer = ByteBuffer.allocate(totalSize);

        buffer.putInt(fragmentNumber);
        buffer.putInt(totalNumOfFragments);
        buffer.putInt(fragmentData.length); // Important for deserialization!
        buffer.put(fragmentData);

        // Prepare the buffer for reading
        buffer.flip();
        return buffer;
   }
	
	public static DataFragment deserialize(ByteBuffer bufferedBlobFragment) {

        int fragmentNumber = bufferedBlobFragment.getInt();
        int totalNumOfFragments = bufferedBlobFragment.getInt();
        int dataLength = bufferedBlobFragment.getInt();
        byte[] fragmentData = new byte[dataLength];
        bufferedBlobFragment.get(fragmentData);

        return new DataFragment(fragmentNumber, totalNumOfFragments, fragmentData);
    }
}
