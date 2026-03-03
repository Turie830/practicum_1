import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FileTest {

    File testFile;

    @BeforeEach
    public void createFile() {
        testFile = new File("TestFile");
    }

    @Test
    public void testName() {
        assertEquals("TestFile", testFile.getName());

        File f1 = new File("ab#c?.txt");
        assertEquals("abc.txt", f1.getName());

        File f2 = new File("");
        assertEquals("defaultName", f2.getName());

        File f3 = new File(null, 0, true);
        assertEquals("defaultName", f3.getName());


        assertNull(testFile.getModificationTime());
        testFile.setName("A#B?.txt");
        assertEquals("AB.txt", testFile.getName());
        assertNotNull(testFile.getModificationTime());
        assertTrue(testFile.getModificationTime().after(testFile.getCreationTime())); //modificationTime > creationTime
    }

    @Test
    public void testSize() {
        // Default for testFile is writable
        long filesize = testFile.getSize();
        assertEquals(0, filesize);

        testFile.enlarge(100);
        filesize = testFile.getSize();
        assertEquals(100, filesize);

        testFile.shorten(50);
        filesize = testFile.getSize();
        assertEquals(50, filesize);
    }

    @Test
    public void testWritable() {
        File nonWritable = new File("notWritable", 100, false);
        assertFalse(nonWritable.isWritable());

        assertThrows(NotWritableException.class, () -> nonWritable.enlarge(50));
        assertEquals(100, nonWritable.getSize());

        assertThrows(NotWritableException.class, () -> nonWritable.shorten(20));
        assertEquals(100, nonWritable.getSize());

        assertThrows(NotWritableException.class, () -> nonWritable.setName("SHOULD NOT WORK"));
        assertEquals("notWritable", nonWritable.getName());

        assertTrue(testFile.isWritable());
    }


    @Test
    public void testOverlappingUsePeriod() {

        File f1 = new File("f1");
        f1.enlarge(1);

        File f2 = new File("f2");
        f2.enlarge(1);

        assertTrue(f1.hasOverlappingUsePeriod(f2));

        File f3 = new File("f3");
        f3.enlarge(1);

        assertFalse(f1.hasOverlappingUsePeriod(f3));
    }
}