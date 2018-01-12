import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    @Test
    public void shouldFormatBookDetailsToString(){
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("Harry Potter", "J.K. Rowling", "1995");
        String bookDetails = "Harry Potter | J.K. Rowling | 1995";
        assertEquals(book.toString(), bookDetails);
    }

}