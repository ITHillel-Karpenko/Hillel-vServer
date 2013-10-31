/**
 * Created with IntelliJ IDEA.
 * User: Vladislav Karpenko
 * Date: 31.10.13
 * Time: 12:23
 */
public class Buffer {
    private Storage storage;

    public Buffer(Storage storage) {
        this.storage = storage;

    }
    public void writeString(String buffer) {
        for (int i = 0; i < buffer.length(); i++) {
            while (!storage.ready());
            storage.write(buffer.charAt(i));
        }
    }
}
