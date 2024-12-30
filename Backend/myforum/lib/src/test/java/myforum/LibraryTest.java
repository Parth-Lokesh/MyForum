package myforum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testGetGreeting() {
        Library library = new Library();
        String result = library.getGreeting();
        assertEquals("Hello from the Library!", result);
    }

    @Test
    public void testIsBookAvailable() {
        Library library = new Library();
        assertTrue(library.isBookAvailable("Java Basics"));
        assertFalse(library.isBookAvailable("Python Basics"));
    }
}
