import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory media;
    @Before
    public void setUp() {
        media = new Inventory();
        media.addBook("a", "author a", "year a");
        media.addBook("b", "author b", "year b");
        media.addBook("c", "author c", "year c");
        media.addBook("d", "author d", "year d");
    }

    @Test
    public void shouldIncrementBookIdWithEveryAdditionalMedia() {
        media.addBook("e", "author e", "year e");
        assertEquals(media.getMediaById(5).getId(), 5);
    }

    @Test
    public void shouldHoldBookAndMovie() {
        media.addMovie("f", "director f", "year f", 6);
        assertEquals("[available] 5: f | director f | year f | 6",
                     media.getMediaById(5).toString());
    }

}