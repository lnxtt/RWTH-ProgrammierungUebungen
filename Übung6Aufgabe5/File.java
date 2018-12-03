public final class File extends Entry<String>{
    private FileNode node;

    public String readContent()
    {
        return node.readContent();
    }

    public void writeContent(String content)
    {
        node.writeContent(content);
    }

    public File(String name)
    {
        this(name, new FileNode());
    }

    private File(String name, FileNode node)
    {
        super(name);
        node = node;
    }

    public String getName()
    {
        return super.getName();
    }

    public Entry createHardlink(String name)
    {
        return new File(name, node);
    }
}
