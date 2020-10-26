package core;

public class Editor {
    private StringBuffer s;

    public Editor() {
        s = new StringBuffer();
    }

    public Editor(String init) {
        s = new StringBuffer(init.trim());
    }

    public void addToHead(String content) {
        s.insert(0, content);
        displayS();
    }

    public void addToTail(String content) {
        s.append(content);
        displayS();
    }

    public void deleteOnHead(int length) {
        s.delete(0, length);
        displayS();
    }

    public void deleteOnTail(int length) {
        length = Math.min(length, s.length());
        s.delete(s.length() - length, s.length());
        displayS();
    }

    public void displayS() {
        System.out.println(s);
    }

}
