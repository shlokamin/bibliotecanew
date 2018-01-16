import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTests {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;

    @Before
    public void setUp()throws Exception{
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995"));
        books.add(new Book("Lord of the Rings", "Tolkien", "1970"));
        biblioteca = new Biblioteca(printStream, bufferedReader, books);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenAppStarts(){
        String message = "Welcome to Biblioteca";
        biblioteca.displayWelcomeMessage();
        verify(printStream).println("Welcome to Biblioteca");
    }

    @Test
    public void shouldDisplayBookDetails() {
        biblioteca.listBooks();
        verify(printStream).println("Harry Potter | J.K. Rowling | 1995\n" + "Lord of the Rings | Tolkien | 1970\n");
    }

    @Test
    public void whenUserSelectsListBooksListBooksIsCalled() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("Harry Potter | J.K. Rowling | 1995\n" + "Lord of the Rings | Tolkien | 1970\n");
        verify(printStream).println("Thank you! Goodbye");
    }

    @Test
    public void shouldExitMenuWhenUserInputIsQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("Thank you! Goodbye");
    }

    @Test
    public void shouldPrintCheckoutWhenUserSelectsCheckoutOnMenu() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("Checkout that item");
        verify(printStream).println("Thank you! Goodbye");
    }
}
