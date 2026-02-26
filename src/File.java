import java.util.Date;

/**
 * A class of files for creating files, involving a name, maxsize, ... TODO
 *
 * @author Obe Willaert
 * @author Arthur Pintelon
 * @author Mauro Devolder
 * @version 1.0
 * <p>
 * TODO
 * @invar size must always be greater than zero
 * @invar
 *
 */

class File {
    private String name;
    private long size; // in bytes
    private final long maxSize = Long.MAX_VALUE; // in bytes
    private final java.util.Date creationTime;
    private java.util.Date modificationTime;
    private long usagePeriod; // timeinterval between modificationTime and creationTime (both not included)
    private boolean writable;

    /**
     *
     * @param name
     * @param size
     * @param writable
     * @pre - name:
     * only capitals, small letters, numbers or these symbols: . - _
     * and need to be atleast 1 char long
     * also case sensitive
     * @post - name is the name of the file
     * - size is the size of the file in bytes
     * - writable is the boolean wether the file is writable
     */
    public File(String name, int size, boolean writable) {
        creationTime = new Date();
    }

    /**
     *
     * @param name
     * @pre - name:
     * only capitals, small letters, numbers or these symbols: . - _
     * and need to be atleast 1 char long
     * also case sensitive
     * @post name is the name of the file
     */
    public File(String name) {
        creationTime = new Date();

        if (name == null) {
            this.name = "defaultName"; // default naam als name leeg is
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : name.toCharArray()) { // check ieder char als het valid is
                if (isValidName(c)) {
                    result.append(c);
                }
            }
            if (result == null) {
                this.name = "defaultName";
            }
            else {
                this.name = result.toString();
            }

        }

    }

    /**
     *
     * @param c
     * @return True als de naam aan de vereisten voldoet, False als het er niet aan voldoet
     *
     */
    public static boolean isValidName(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9') ||
                c == '.' || c == '-' || c == '_';
    }


    /**
     * @param enlargeSize
     * @pre enlargeSize > 0 and enlargeSize + getSize() < maxSize()
     */
    public void enlarge(int enlargeSize) {
        size = getSize() + enlargeSize;
    }

    /**
     * @param shortenSize
     * @pre shortenSize > 0 and getSize - shortenSize > 0
     *
     */
    public void shorten(int shortenSize) {
        size = getSize() - shortenSize;
    }

    /**
     *
     *
     */
    public boolean hasOverlappingUsePeriod(File file) {
        if (file.getModificationTime() == null){
            return false;
        }

        return file.getCreationTime().before(this.getModificationTime())
                || this.getCreationTime().before(file.getModificationTime());/* als file 2 begint voor file 1 eindigt is er overlap */

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public java.util.Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(java.util.Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getUsagePeriod() {
        return usagePeriod;
    }

    public void setUsagePeriod(long usagePeriod) {
        this.usagePeriod = usagePeriod;
    }

    public boolean isWritable() {
        return writable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }
}