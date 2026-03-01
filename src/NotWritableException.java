/**
 * Een uitzondering die aangeeft dat een schrijfoperatie (naam wijzigen of grootte wijzigen)
 * niet uitgevoerd kon worden omdat het bestand niet schrijfbaar is.
 *
 * @author Obe Willaert
 * @author Arthur Pintelon
 * @author Mauro Devolder
 * @version 1.0
 */
public class NotWritableException extends RuntimeException {
    private final File file;

    /**
     * Creates a new not writable exception for a file
     *
     * @param file Het bestand waarop de schrijfoperatie mislukte.
     * @post new.getFile() == file
     */
    public NotWritableException(File file) {
        super("File is not writable: " + (file != null ? file.getName() : "null"));
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
