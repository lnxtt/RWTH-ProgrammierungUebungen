/**
 *
 * Die Klasse represaentiert den Ordner eines Ordnersystems
 *
 */
public class Directory extends Node
{
    /**
     * Die Eintraege eines Ordners
     */
    private Entry[] entries;

    /**
     * Erstellt einen neuen Ordner mit beliebig vielen Entraegen
     * @param newEntries Eintraege des Ordners
     */
    public Directory(Entry... newEntries){
        for (Entry entry : newEntries){
            addEntry(entry);
        }
    }

    /**
     * Liefert die Eintraege des Ordners
     * @return Ein Array aller Eintraege des Ordners
     */
    public Entry[] getEntries() {
        return entries;
    }

    /**
     * Liefert zurueck, ob ein Eintrag mit dem Namen vorhanden ist
     * @param name Name nach dem gesucht wird
     * @return True, wenn der ein Eintrag mit dem Namen gefunden wurde, andernfalls false
     */
    public boolean containsEntry(String name)
    {
        return getEntry(name) != null;
    }

    /**
     * Liefert den Eintrag des Ordners mit dem angegebenem Namen
     * null, falls nicht vorhanden
     * @param name Name des gewünschten Eintrags
     * @return Eintrag im Ordner mit gewünschtem Namen
     */
    public Entry getEntry(String name)
    {
    	if(entries != null){
            for(int i = 0;i < entries.length;i++)
            {
            	if(entries[i].getName() == name)
            	{
            	    return entries[i];
            	}
            }
	}
        return null;
    }

    /**
     * Erstellt einen Unterordner als Eintrag, mit gegenem Namen.
     * Unterordner steht an letzter Stelle der Eintraege
     * @param name Name des neuen Unterordners
     * @return Der neue Unterordner
     */
    public Entry createDirectory(String name)
    {
        if(containsEntry(name)){
            System.out.println("Error : the directory : " + name + " already exist.");
            return null;
        }
        Entry newDirec = new Entry(name, new Directory());
        this.addEntry(newDirec);
        return newDirec;
    }

    /**
     * Erstellt eine neue Datei in dem Ordner
     * Datei steht an letzter Stelle der Eintraege
     * @param name name der Datei
     * @param content Inhalt der neuen Datei
     * @return Die neu erstellte Datei
     */
    public Entry createFile(String name, String content)
    {
        if(containsEntry(name)){
            System.out.println("Error : the file : " + name + " already exist.");
            return null;
        }
        Entry newFile = new Entry(name, new File(content));
        this.addEntry(newFile);
        return newFile;
    }

    /**
     * Erstellt neuen Eintrag mit anderem Namen, der auf das selbe Node verweist, wie der uebergebene Eintrag
     * @param name Name der neuen Eintrags
     * @param entry Eintrag, dessen Referenz uebernommen wird
     * @return neuer Eintrag mit anderem Namen und gleicher Referenz
     */
    public Entry createHardlink(String name, Entry entry)
    {
        if(containsEntry(name) == false){
            System.out.println("Error : the Hardlink : " + name + " already exist.");
            return null;
        }
        Entry newEntry = entry.createHardlink(name);
        return newEntry;
    }

    /**
     * Fuegt einen Eintrag dem Ordner hinzu
     * Neuer Eintrag wird hinten an das Array angefuegt
     * @param newEntry Einzufuegender Eintrag
     */
    private void addEntry(Entry newEntry)
    {
        Entry[] newEntries = new Entry[1];
        if (entries == null)
        {
            entries = newEntries;
            entries[0] = newEntry;
            this.touch();
        }
        else
        {
            newEntries = new Entry[entries.length+1];
            if (entries.length > 0)
            {
                for(int i = 0;i < entries.length;i++)
                {
                    newEntries[i] = entries[i];
                }
            }

            newEntries[entries.length] = newEntry;
            this.entries = newEntries;
            this.touch();
        }
    }

    /**
     * Erstellt einen leeren Ordner
     * Mit einem Array der Laenge 0
     * @return Ordner ohneEintraege
     */
    public static Directory createEmpty()
    {
        return new Directory();
    }

    /**
     * Schreibt das Ordnersystem in die Konsole
     * @param name Name des Ordners, an dessen Unterordner und Dateien ausgegeben werden
     * @param visitor
     */
    public void accept(String name, Visitor visitor)
    {
        if (entries != null)
        {

            visitor.visitDirectory(name, this);
            for ( int i = 0; i < entries.length; i++)
            {
                if(entries[i] != null)
                {
                    if(entries[i].getAsFile() != null)
                    {
                        visitor.visitFile(entries[i].getName(), entries[i].getAsFile());
                    }
                    else if (entries[i].getAsDirectory() != null)
                    {
                        entries[i].getAsDirectory().accept(entries[i].getName(), visitor);
                        visitor.reset();
                    }
                }
            }
        }

        visitor.visitedDirectory();
    }
}
