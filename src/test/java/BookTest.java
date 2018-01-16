import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    @Test
    public void shouldFormatBookDetailsToString(){
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("Harry Potter", "J.K. Rowling", "1995",1);
        String bookDetails = "[available] 1: Harry Potter | J.K. Rowling | 1995";
        assertEquals(book.toString(), bookDetails);
    }

    @Test
    public void shouldIncrementBookIdWhenNewBookIsInstantiated(){
        Book book1 = new Book("Harry Potter a", "J.K. Rowling", "1995");
        Book book2 = new Book("Harry Potter b", "J.K. Rowling", "1995");
        assertEquals(book2.getId(), 2);


    }

}