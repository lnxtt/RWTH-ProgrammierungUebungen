public class Entry{

    String name;
    Node node;

    public Entry(String name; Node node){
        this.name = name;
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public File getAsFile(){
        //TODO Überprüfen,ob der Entry wirklich ein File ist und falls ja als File zurückgeben
        return null;
    }

    public Directory getAsDirectory(){
        //TODO Überprüfen,ob der Entry ein Directory ist und falls ja als Directory zurückgeben
        return null;
    }

    public Entry createHardlink(String newName){
        //TODO Soll einen neuen HardLink erstellen, der auf das gleiche node wie dieser Entry verweist
        return null;
    }
}