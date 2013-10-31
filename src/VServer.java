/**
 * Created with IntelliJ IDEA.
 * User: Vladislav Karpenko
 * Date: 31.10.13
 * Time: 12:22
 */
public class VServer {
    private String receivedData;

    public void read(VStream stream)
    {
        receivedData = stream.read();
        stream.confirm();
    }

    public void save(Storage storage) {
        Buffer buffer = new Buffer(storage);
        buffer.writeString(encode(receivedData));

    }

    private String encode(String source) {...}

}
