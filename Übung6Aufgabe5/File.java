/**
 * 
 * Die Klasse stellt eine Datei dar
 *
 */
public class File extends Node{

	/**
	 * Der Inhalt der Datei
	 */
    private String content;

    /**
     * Erstellt eine neue Datei, mit gegebenem Inhalt
     * @param content Inhalt der Datei
     */
    public File(String content){
        writeContent(content);
    }

    /**
     * Überschreibt den Inhalt der Datei und aktualisiert das Datum der letzten Bearbeitung
     * @param content Der neue Inhalt der Datei
     */
    public void writeContent(String content){
        this.content = content;
        this.touch();
    }

    /**
     * Liest den Inhalt der Datei
     * @return Inhalt der Datei
     */
    public String readContent() {
        return content;
    }
}