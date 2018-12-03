public class FileNode extends Node<String>{
    String readContent()
    {
        return super.content;
    }

    void writeContent(String content)
    {
        super.content = content;
        touch();
    }
}