import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    @Test
    public void bookDisplaysDetails(){
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("Harry Potter", "J.K. Rowling", "1995");

        String bookDetails = "Harry Potter | J.K. Rowling | 1995";

        book.displayDetails(printStream);

        verify(printStream).println(bookDetails);
    }

}