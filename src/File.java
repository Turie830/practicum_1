import java.util.Date;

/**
 * A class of files in a file system
 *
 * @author Obe Willaert
 * @author Arthur Pintelon
 * @author Mauro Devolder
 * @version 1.0
 *
 * @invar The name is always valid (only letters, digits, '.', '-', '_'; never empty)
 * @invar 0 <= getSize() && getSize() <= getMaxSize()
 * @invar getCreationTime() != null
 * @invar If getModificationTime() != null then getModificationTime().after(getCreationTime())
 */
public class File {
    private static final long maxSize = Long.MAX_VALUE; // in bytes
    private final java.util.Date creationTime;
    private String name;
    private long size; // in bytes
    private java.util.Date modificationTime;
    private long usagePeriod; // timeinterval between modificationTime and creationTime (both not included)
    private boolean writable;

    /**
     * Creates a new File with given name, size and writability.
     *
     * @param name
     * @param size
     * @param writable
     *
     * @pre  size >= 0 && size <= getMaxSize()
     * @post getName() is a valid non-empty name derived from the parameter (or "defaultName")
     * @post getSize() == size
     * @post isWritable() == writable
     * @post getCreationTime() equals the moment of creation
     * @post getModificationTime() == null (file not yet modified)
     */
    public File(String name, int size, boolean writable) {
        setNameCreation(name);
        creationTime = new Date();
        this.size = size;
        this.writable = writable;
    }

    /**
     * Creates a new empty writable file with the given name.
     * @param name
     *
     * @post getName() is valid, getSize() == 0, isWritable() == true,
     * creation time set, modification time still null
     */
    public File(String name) {
        this(name, 0, true);
    }

    /**
     * Checks whether a character is allowed in a file name.
     *
     * @param c
     * @return true if c is a letter (A-Za-z), digit (0-9), '.', '-' or '_'
     */
    public static boolean isValidChar(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9') ||
                c == '.' || c == '-' || c == '_';
    }

    /**
     * Internal helper that sets a valid name.
     * Invalid characters are removed and null/empty are set to "defaultName".
     */
    private void setNameCreation(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "defaultName";
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : name.toCharArray()) {
                if (isValidChar(c)) {
                    result.append(c);
                }
            }
            if (result.isEmpty()) {
                this.name = "defaultName";
            } else {
                this.name = result.toString();
            }
        }
    }

    /**
     * Increases the size of the file.
     *
     * @param enlargeSize
     *
     * @pre enlargeSize > 0
     * @pre getSize() + enlargeSize <= getMaxSize()
     * @throws NotWritableException if !isWritable()
     * @post getSize() == old size + enlargeSize
     * @post getModificationTime() is updated to current time
     */
    public void enlarge(int enlargeSize) {
        if (!isWritable()) throw new NotWritableException(this);

        size = getSize() + enlargeSize;
        modificationTime = new Date();

    }

    /**
     * Decreases the size of the file.
     *
     * @param shortenSize
     *
     * @pre shortenSize > 0
     * @pre getSize() - shortenSize >= 0
     * @throws NotWritableException if !isWritable()
     * @post getSize() == old size - shortenSize
     * @post getModificationTime() is updated
     */
    public void shorten(int shortenSize) {
        if (!isWritable()) throw new NotWritableException(this);

        size = getSize() - shortenSize;
        modificationTime = new Date();
    }

    /**
     * Checks whether the use period of this file overlaps with the given file.
     *
     * @param file the other file
     * @return true if the use periods overlap else false
     */
    public boolean hasOverlappingUsePeriod(File file) {
        if (file.getModificationTime() == null) {
            return false;
        }

        return file.getCreationTime().before(this.getModificationTime())
                || this.getCreationTime().before(file.getModificationTime());/* als file 2 begint voor file 1 eindigt is er overlap */

    }

    public String getName() {
        return name;
    }

    /**
     * Changes the name of this file.
     *
     * @param name
     * @throws NotWritableException if !isWritable()
     * @post getName() is a valid name derived from the parameter
     * @post getModificationTime() is updated
     */
    public void setName(String name) {
        if (!isWritable()) {
            throw new NotWritableException(this);
        }
        setNameCreation(name);
        this.modificationTime = new Date();
    }

    public long getSize() {
        return size;
    }

    private void setSize(long size) {
        this.size = size;
    }

    public static long getMaxSize() {
        return maxSize;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public java.util.Date getModificationTime() {
        return modificationTime;
    }

    private void setModificationTime(java.util.Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getUsagePeriod() {
        if (modificationTime == null) return 0;
        return modificationTime.getTime() - creationTime.getTime();
    }

    private void setUsagePeriod(long usagePeriod) {
        this.usagePeriod = usagePeriod;
    }

    public boolean isWritable() {
        return writable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }
}