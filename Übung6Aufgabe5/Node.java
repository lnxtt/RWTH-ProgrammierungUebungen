/**
 * 
 * Die Klasse symbolisiert Dateien und Ordner eines Ordnersystems
 *
 */
public abstract class Node
{

	/**
	 * "Datum" der letzten Bearbeitung, Millisekunden seit dem 1.Januar 1970
	 */
    private long lastModified;

    /**
     * Erstellt ein neues Node und aktualisiert das Datum
     */
    public Node()
    {
        touch();
    }

    /**
     * aktualisiert das Datum der Bearbeitung auf das aktuelle
     */
    public void touch()
    {
        this.lastModified = System.currentTimeMillis();
    }

    /**
     * Liefert das letzte Datum der Berarbeitung
     * @return Datum der Bearbeitung
     */
    public long getLastModified()
    {
        return lastModified;
    }
}