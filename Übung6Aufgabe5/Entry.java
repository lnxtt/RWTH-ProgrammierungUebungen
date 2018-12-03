public abstract class Entry<T>{

    private String name;

    public Entry(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public File getAsFile(){
        return this instanceof File ? (File)this : null;
    }

    public Directory getAsDirectory(){
        return this instanceof Directory ? (Directory)this : null;
    }

    public abstract Entry createHardlink(String newName);
}
