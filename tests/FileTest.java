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
        // Case 1.
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


        nonWritable.enlarge(50);
        long size = nonWritable.getSize();
        assertEquals(100, size);

        nonWritable.shorten(20);
        size = nonWritable.getSize();
        assertEquals(100, size);

        assertTrue(testFile.isWritable());
    }
}