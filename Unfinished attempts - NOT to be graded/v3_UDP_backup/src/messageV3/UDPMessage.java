package messageV3;

import java.nio.ByteBuffer;

public interface UDPMessage {
	 public void incrementNum();
	 public void updateTimestamp();
	 public ByteBuffer[] serialize();
	 public static Message deserialize(ByteBuffer[] buffers) {
		return null;
	}
}
