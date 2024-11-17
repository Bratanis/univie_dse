package v3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import messageV3.Message;

public class BACKUP_UDP_Server {

    //For Debugging_________________________________
    private static final Logger logger = Logger.getLogger(BACKUP_UDP_Server .class.getName());
    static {
        Logger.getLogger("BACKUP_UDP_Server ").setLevel(Level.ALL);
    }
    
    public static void main(String[] args) throws IOException {
        
        DatagramSocket s = null; 
        int serverPort = 2345;
        try {
            s = new DatagramSocket(serverPort);

            int numOfBlobSizes = 6;
            int iterationsPerBlobSize = 10;
            int totalIterations = iterationsPerBlobSize * numOfBlobSizes;
            logger.info("The server will run for " + totalIterations + " iterations!");
            
            for (int iteration = 0; iteration < totalIterations; ++iteration) {

                ByteBuffer clientMessageBuffer = ByteBuffer.allocate(65535);        
                DatagramPacket request = new DatagramPacket(clientMessageBuffer.array(), 
                                                            clientMessageBuffer.capacity());
                s.receive(request);

                // Deserialize the received data
                Message requestMessage = Message.deserialize(clientMessageBuffer);
                logger.info("Received from client: " + requestMessage);

                // Check if the message is fragmented
                if (requestMessage.shouldBeFragmented()) {
                    // Handle fragmented message reassembly
                    List<ByteBuffer> fragmentBuffers = new ArrayList<>();
                    fragmentBuffers.add(clientMessageBuffer); // Add initial fragment

                    while (!requestMessage.isComplete()) {
                        clientMessageBuffer.clear();
                        request = new DatagramPacket(clientMessageBuffer.array(), clientMessageBuffer.capacity());
                        s.receive(request);
                        fragmentBuffers.add(ByteBuffer.wrap(request.getData(), 0, request.getLength()));
                        requestMessage = Message.deserialize(clientMessageBuffer);
                    }
                    
                    // Reassemble message
                    requestMessage = Message.deserializeLargeMessage(fragmentBuffers);
                }

                requestMessage.incrementNum();
                logger.info("Sending back: " + requestMessage);

                ByteBuffer responseBuffer = requestMessage.serialize();    
                DatagramPacket reply = new DatagramPacket(responseBuffer.array(),
                                                          responseBuffer.capacity(),
                                                          request.getAddress(),
                                                          request.getPort());
                s.send(reply);
            }
        } catch (SocketException e) {
            logger.warning("Socket: " + e.getMessage());
        } catch (IOException e) {
            logger.warning("IO: " + e.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
