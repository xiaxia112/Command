package core;

import org.junit.Test;

public class EditorTest {
    private final Editor editor = new Editor(" loWorld ");

    @Test
    public void addToHead() {
        editor.addToHead("-test-");
    }

    @Test
    public void addToTail() {
        editor.addToTail("-test-");
    }

    @Test
    public void deleteOnHead() {
        editor.deleteOnHead(3);
    }

    @Test
    public void deleteOnTail() {
        editor.deleteOnTail(5);
    }
}