public final class Directory extends Entry<Entry[]>
{
    private DirectoryNode node;

    private Directory(String name, DirectoryNode node){
        super(name);
        this.node = node;
    }

    public Directory(String name){
        this(name, new DirectoryNode());
    }

    public Directory createEmpty(){
        return new Directory(null, new DirectoryNode());
    }

    public boolean containsEntry(String name){
        return getEntry(name) != null;
    }

    public Entry getEntry(String name){
        for(Entry entry : node.content){
            if(entry.getName() == name){
                return entry;
            }
        }
        return null;
    }

    public Entry createDirectory(String name){
        if(containsEntry(name) == false){
            Directory newEntry = new Directory(name);
            addEntry(newEntry);
            return newEntry;
        }
        else{
            System.out.println("Error : the directory : " + name + " already exist.");
        }
        return null;
    }

    public Entry createFile(String name, String content){
        if(containsEntry(name) == false){
            File newEntry = new File(name);
            newEntry.writeContent(content);
            addEntry(newEntry);
            return newEntry;
        }
        else{
            System.out.println("Error : the file : " + name + " already exist.");
        }
        return null;
    }
    
    public Entry createHardlink(String name){
        return new Directory(name, node);
    }
    
    public Entry createHardlink(String name, Entry entry){
        if(containsEntry(name) == false){
            Entry newLink = entry.createHardlink(name);
            addEntry(newLink);
            return newLink;
        }
        else{
            System.out.println("Error : the Hardlink : " + name + " already exist.");
        }
        return null;
    }

    public void addEntry(Entry newEntry){
        Entry[] newEntries = new Entry[node.content.length + 1];
        for(int i = 0;i < node.content.length-1;i++){   //kopiert das Array
            newEntries[i] = node.content[i];
        }
        newEntries[node.content.length] = newEntry;
        node.content = newEntries;
        node.touch();
    }
}
