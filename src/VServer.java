/**
 * Created with IntelliJ IDEA.
 * User: Vladislav Karpenko
 * Date: 31.10.13
 * Time: 12:22
 */
public class VServer implements Runnable{
    private VStream[] streams;
    private Storage storage;

    public static void main(String[] args) {
        VServer vServer = new VServer(VStream[], Storage);
        Thread thread = new Thread(vServer);
        thread.start();

        //do something
        thread.interrupt();

    }

    public VServer(VStream[] vStreams, Storage storage) {
        this.streams = vStreams;
        this.storage = storage;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            for (int i=0; i < streams.length; i++) {
                String receivedData = this.read(streams[i]);
                if (receivedData==null) continue;
                this.save(storage, receivedData);
            }
        }
    }

    private synchronized String read(VStream stream)
    {
        String receivedData = stream.read();
        if(receivedData!=null) stream.confirm();
        return receivedData;
    }

    private synchronized void save(Storage storage, String receivedData) {
        Buffer buffer = new Buffer(storage);
        buffer.writeString(encode(receivedData));

    }

    private String encode(String source) {...}

}
