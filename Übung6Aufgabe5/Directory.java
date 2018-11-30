public class Directory extends Node{
    Entry[] entries;

    public Directory(Entry... newEntries){
        for (Entry entry : newEntries){
                addEntry(entry);
        }
    }

    public Entry[] getEntries() {
        return entries;
    }

    public boolean containsEntry(String name){
        for(int i = 0;i < entries.length;i++){
            if(entries[i].getName() == name){
                return true;
            }
        }
        return false;
    }

    public Entry getEnttry(String name){
        for(int i = 0;i < entries.length;i++){
            if(entries[i].getName() == name){
                return entries[i];
            }
        }
        return null;
    }

    public Entry createDirectory(String name){
        if(containsEntry(name) == false){
            //TODO Das neue leere Direcotry als Entry in dieses Directory schreiben
        }
        else{
            System.out.println("Error : the directory : " + name + " already exist.");
        }
        return null;
    }

    public Entry createFile(String name, String content){
        if(containsEntry(name) == false){
            //Todo Den neuen File als Entry in dieses Directory schreiben
        }
        else{
            System.out.println("Error : the file : " + name + " already exist.");
        }
        return null;
    }

    public Entry createHardlink(String name, Entry entry){
        if(containsEntry(name) == false){
            //Todo  den neuen Hardlink als Entry in dieses Directory schreiben
        }
        else{
            System.out.println("Error : the Hardlink : " + name + " already exist.");
        }
        return null;
    }

    private void addEntry(Entry newEntry){
        Entry[] newEntries = new Entry[entries.length+1];
        for(int i = 0;i < entries.length-1;i++){
            newEntries[i] = entries[i];
        }
        newEntries[entries.length] = newEntry;
        this.entries = newEntries;
        this.touch();
    }
}