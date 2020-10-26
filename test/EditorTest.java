import org.junit.Test;

public class EditorTest {
    private Editor editor = new Editor(" 012345 ");

    @Test
    public void addToHead() {
        editor.addToHead("test -addToHead()");
    }

    @Test
    public void addToTail() {
        editor.addToTail("test -addToTail()");
    }

    @Test
    public void deleteOnHead() {
        editor.deleteOnHead(3);
    }

    @Test
    public void deleteOnTail() {
        editor.deleteOnTail(3);
    }
}