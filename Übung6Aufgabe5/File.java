public class File extends Node{

    String content;

    public File(String content){
        writeContent(content);
    }

    public void writeContent(String content){
        this.content = content;
        this.touch();
    }

    public String readContent() {
        return content;
    }
}