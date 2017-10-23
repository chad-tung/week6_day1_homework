import static org.junit.Assert.assertEquals;
import org.junit.*;

public class LibraryTest {
    Library library;
    Book book;

    @Before
    public void before() {
        library = new Library();
        book = new Book();
    }

    @Test
    public void bookCount() {
        assertEquals(0, library.bookCount());
        library.add(book);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void libraryIsFull() {
        assertEquals(false, library.isLibraryFull());
        for(int i=0; i < 15; i++) {
            library.add(book);
        }
        assertEquals(true, library.isLibraryFull());
    }

    @Test
    public void libraryIsEmpty() {
        for(int i=0; i < 15; i++) {
            library.add(book);
        }
        assertEquals(15, library.bookCount());
        assertEquals(false, library.isLibraryEmpty());
        library.discardAll();
        assertEquals(0, library.bookCount());
        assertEquals(true, library.isLibraryEmpty());
    }
}
