public abstract class Node<T>{
    T content;  
    long lastModified;

    public Node(){
        touch();
    }

    public void touch(){
        this.lastModified = System.currentTimeMillis();
    }

    public long getLastModified(){
        return lastModified;
    }
}
