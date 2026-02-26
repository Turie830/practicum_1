import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
        void testNameFilter() {
            File f = new File("ab#c?.txt");
            assertEquals("abc.txt", f.getName());
        }

        @Test
        void testNameFilter2() {
            File f = new File("");
            assertEquals("defaultName", f.getName());
        }

        @Test
        void testNameFilter3() {
            File f = new File("%")



    }















}