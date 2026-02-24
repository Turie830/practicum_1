class File {
    private String name;
    private long size; // in bytes
    private final long maxSize; // in bytes
    private final java.util.Date creationTime;
    private java.util.Date modificationTime;
    private long gebruiksperiode; // timeinterval between modificationTime and creationTime (both not included)
    private boolean writable;

    /**
     *
     * @param name
     * @param size
     * @param writable
     */
    public File (String name, int size, boolean writable) {

    }

    public File(String name) {

    }


    /**
     *
     */
    public void enlarge(int enlargeSize) {

    }

    /**
     *
     * */
    public void shorten(int shortenSize) {

    }

    /**
     *
     * */
    public void hasOverlappingUsePeriod(File file) {

    }

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

    public long getGebruiksperiode() {
        return gebruiksperiode;
    }

    public void setGebruiksperiode(long gebruiksperiode) {
        this.gebruiksperiode = gebruiksperiode;
    }

    public boolean isWritable() {
        return writable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }
}

