import java.util.Date;

/**
 * A class of files for creating files, involving a name, maxsize, ... TODO
 *
 * @author  Obe Willaert
 * @author  Arthur Pintelon
 * @author  Mauro Devolder
 *
 * @version 1.0
 *
 * TODO
 * @invar   size must always be greater than zero
 *
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
        creationTime = new Date();
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
        creationTime = new Date();
        if (isValidName(name) == true) {
            this.name = name;
        } else {
            if (name == null) {
                this.name = "defaultName";
            } else {
                StringBuilder result = new StringBuilder();
                for (char c : name.toCharArray()) {
                    if (isAllowed(c)) {
                        result.append(c);
                    }
                }
                this.name = result.toString();
            }
        }
    }

        /**
         *
         * @param name
         *  @return True als de naam aan de vereisten voldoet, False als het er niet aan voldoet
         *
         */
    public static boolean isValidName (String name) {
        if (name == null || name.isEmpty()) return false;
        return name.matches("[A-Za-z0-9._-]+");
    }


    /**
     * @param enlargeSize
     *
     * @pre enlargeSize > 0 and enlargeSize + getSize() < maxSize()
     */
    public void enlarge(int enlargeSize) {
        size = getSize() + enlargeSize;
    }

    /**
     * @param shortenSize
     *
     * @pre shortenSize > 0 and getSize - shortenSize > 0
     * */
    public void shorten(int shortenSize) {
        size = getSize() - shortenSize;
    }

    /**
     *
     * */
    public boolean hasOverlappingUsePeriod(File other) {
        if (other == null) return false;

        Date start1 = this.getCreationTime();
        Date end1 = this.getModificationTime() != null ? this.getModificationTime() : new Date();
        Date start2 = other.getCreationTime();
        Date end2 = other.getModificationTime() != null ? other.getModificationTime() : new Date();

        if (end1.before(start1) || end2.before(start2)){

            Date tstart1 = start1;
            Date tstart2 = start2;
            Date tend1 = end1;
            Date tend2 = end2;

            start1 = tstart2;
            start2 = tstart1;
            end1 = tend2;
            end2 = tend1;

        }

        return start1.before(end2) && start2.before(end1);
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