package core;

public class Editor {

    private StringBuffer s;

    public Editor() {
        s = new StringBuffer();
    }

    public Editor(String init) {
        s = new StringBuffer(init.trim());
    }

    public String addToHead(String content) {
        s.insert(0, content);
        displayS();
        return String.valueOf(s);
    }

    public String addToTail(String content) {
        s.append(content);
        displayS();
        return String.valueOf(s);
    }

    public String deleteOnHead(int length) {
        s.delete(0, length);
        displayS();
        return String.valueOf(s);
    }

    public String deleteOnTail(int length) {
        length = Math.min(length, s.length());
        s.delete(s.length() - length, s.length());
        displayS();
        return String.valueOf(s);
    }

    public void displayS() {
        System.out.println(s);
    }

    public void setS(String s) {
        this.s = new StringBuffer(s);
    }


}
