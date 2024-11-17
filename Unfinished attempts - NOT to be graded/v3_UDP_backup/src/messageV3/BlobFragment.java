package messageV3;

import java.nio.ByteBuffer;

public class BlobFragment {
	private int fragmentNumber;
    private int totalNumOfFragments;
    private byte[] fragmentData;

    public BlobFragment(int fragmentNumber, int totalNumOfFragments, byte[] dataFragment) {
        this.fragmentNumber = fragmentNumber;
        this.totalNumOfFragments = totalNumOfFragments;
        this.fragmentData = dataFragment;
    }

    public int getSequenceNumber() {
        return fragmentNumber;
    }

    public int getTotalChunks() {
        return totalNumOfFragments;
    }

    public byte[] getData() {
        return fragmentData;
    }

	public ByteBuffer serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
