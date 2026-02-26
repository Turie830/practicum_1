/**
 * A class of files for creating files, involving a name, maxsize, ... TODO
 *
 * @author  Obe Willaert
 * @author  Arthur Pintelon
 * @author  Mauro Devolder
 *
 * @version 1.0
 *
 * TODO wat is dit????
 * @invar	The capacity of a tank is a positive number.
 * 			| isValidCapacity(getCapacity())
 * @invar	The contents of a tank is a positive number, less than or equal to the capacity of the tank.
 * 			| canHaveAsContents(getContents())
 *
 */

class File {
    private String name;
    private long size; // in bytes
    private final long maxSize; // in bytes
    private final java.util.Date creationTime;
    private java.util.Date modificationTime;
    private long usagePeriod; // timeinterval between modificationTime and creationTime (both not included)
    private boolean writable;

    /**
     *
     * @param name
     * @param size
     * @param writable
     *
     * @pre
     *  - name:
     *      only capitals, small letters, numbers or these symbols: . - _
     *      and need to be atleast 1 char long
     *      also case sensitive
     *
     * @post
     *  - name is the name of the file
     *  - size is the size of the file in bytes
     *  - writable is the boolean wether the file is writable
     */
    public File (String name, int size, boolean writable) {

    }

    /**
     *
     * @param name
     *
     * @pre
     *  - name:
     *      only capitals, small letters, numbers or these symbols: . - _
     *      and need to be atleast 1 char long
     *      also case sensitive
     *
     * @post name is the name of the file
     */
    public File(String name) {

    }


    /**
     * @param enlargeSize
     *
     * @pre enlargeSize > 0 and enlargeSize + getSize() < maxSize()
     */
    public void enlarge(int enlargeSize) {
        size = getSize() + enlargeSize
    }

    /**
     * @param shortenSize
     *
     * @pre shortenSize > 0 and getSize - shortenSize > 0
     * */
    public void shorten(int shortenSize) {
        size = getSize() - shortenSize
    }

    /**
     *
     * */
    public void hasOverlappingUsePeriod(File file) {

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

    public java.util.Date getCreationTime() {
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