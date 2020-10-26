public class Editor {
    StringBuffer s;

    Editor(){
        s = new StringBuffer();
    }

    Editor(String init){
        s = new StringBuffer(init.trim());
    }

    public void addToHead(String content){
        s.insert(0, content);
        displayS();
    }

    public void addToTail(String content){
        s.append(content);
        displayS();
    }

    public void deleteOnHead(int length){
        s.delete(0, length);
        displayS();
    }

    public void deleteOnTail(int length){
        s.delete(s.length() - length, s.length());
        displayS();
    }

    public void displayS(){
        System.out.println(s);
    }

}
