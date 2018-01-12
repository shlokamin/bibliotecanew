import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTests {
    private PrintStream printstream;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;

    @Before
    public void setUp()throws Exception{
        printstream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995"));
        books.add(new Book("Lord of the Rings", "Tolkien", "1970"));
        biblioteca = new Biblioteca(printstream, bufferedReader, books);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenAppStarts(){
        String message = "Welcome to Biblioteca";
        biblioteca.displayWelcomeMessage();
        verify(printstream).println("Welcome to Biblioteca");
    }

    @Test
    public void shouldDisplayBookDetails() {
        biblioteca.listBooks();
        verify(printstream).println("Harry Potter | J.K. Rowling | 1995\n" + "Lord of the Rings | Tolkien | 1970\n");
    }

    @Test
    public void whenUserSelectsListBooksListBooksIsCalled() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        biblioteca.carryOutMenuSelection();
        verify(printstream).println("Harry Potter | J.K. Rowling | 1995\n" + "Lord of the Rings | Tolkien | 1970\n");
    }

    @Test
    public void shouldExitMenuWhenUserInputIsQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Quit");
        biblioteca.quit();
        verify(printstream).println("Thank you! Goodbye");
    }
}
