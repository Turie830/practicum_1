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
        //TODO
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
    public void testFilter1() {
        File f = new File("ab#c?.txt");
        assertEquals("abc.txt", f.getName());
    }

    @Test
    public void testFilter2() {
        File f = new File("");
        assertEquals("defaultName", f.getName());

    }
}