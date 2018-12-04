/**
 * 
 * Die Klasse repraesentiert einen Eintrag eines Ordners mittels Referenz
 *
 */
public class Entry
{

	/**
	 * Name des Eintrags
	 */
    private String name;
    /**
     * Objekt auf das die Referenz zeigt
     */
    private Node node;

    /**
     * Erstellt einen Eintrag mitsamt Name und Referenz
     * @param name Name des neuen Eintrags
     * @param node Referenz des neuen Eintrags
     */
    public Entry(String name, Node node)
    {
        this.name = name;
        this.node = node;
    }

    /**
     * Liefert den Namen des Eintrags
     * @return Name des Eintrags
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Liefert das Objekt auf das die Referenz zeigt, sofern es eine Datei ist, andernfalls null.
     * @return Datei des Eintrags
     */
    public File getAsFile()
    {
    	if (this.node instanceof File)
    	{
    		return (File)this.node;
    	}
        return null;
    }

    /**
     * Liefert das Objekt auf das die Referenz zeigt, sofern es eine Ordner ist, andernfalls null.
     * @return Ordner des Eintrags
     */
    public Directory getAsDirectory()
    {
        if (this.node instanceof Directory)
        {
        	return (Directory) this.node;
        }
        return null;
    }

    /**
     * Erstellt einen neuen Eintrag, der auf das gleiche Node zeigt, wie der aktuelle Eintrag
     * @param newName Name des neuen Eintrags
     * @return Eintrag mit angegebenem Namen und gleicher Referenz
     */
    public Entry createHardlink(String newName)
    {
        return new Entry(newName, this.node);
    }
}