import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory books;
    @Before
    public void setUp() {
        books = new Inventory();
        books.addBook("a", "author a", "year a");
        books.addBook("b", "author b", "year b");
        books.addBook("c", "author c", "year c");
        books.addBook("d", "author d", "year d");
    }

    @Test
    public void shouldIncrementBookIdWithEveryAdditionalBook() {
        books.addBook("e", "author e", "year e");
        assertEquals(books.getBookById(5).getId(), 5);
    }

}