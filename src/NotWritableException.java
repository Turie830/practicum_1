/**
 * An exception that get's called when a write operation (change size or name) can't be executed since it's not writable
 *
 * @author Obe Willaert
 * @author Arthur Pintelon
 * @author Mauro Devolder
 * @version 1.0
 */
public class NotWritableException extends RuntimeException {
    /**
     * Creates a new not writable exception for a file
     *
     * @param file The file on where the operation failed
     * @post new.getFile() == file
     */
    public NotWritableException(File file) {
        super("File is not writable: " + (file != null ? file.getName() : "null"));
    }
}
