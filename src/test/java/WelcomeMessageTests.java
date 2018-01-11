import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
public class WelcomeMessageTests {
    private PrintStream printstream;
    private Biblioteca biblioteca;

    @Before
    public void setUp()throws Exception{
        printstream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printstream);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenAppStarts(){
        String message = "Welcome to Biblioteca";

        biblioteca.displayWelcomeMessage();

        verify(printstream).println("Welcome to Biblioteca");
    }

    @Test
    public void shouldDisplayBooksAfterWelcomeMessage() {
        biblioteca.listBooks();

        verify(printstream).println("Harry Potter");
        verify(printstream).println("Lord of the Rings");


    }


}
