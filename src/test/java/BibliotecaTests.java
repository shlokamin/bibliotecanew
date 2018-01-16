import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
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
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995",1));
        books.add(new Book("Lord of the Rings", "Tolkien", "1970",2));
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
        verify(printStream).println("1: Harry Potter | J.K. Rowling | 1995\n" + "2: Lord of the Rings | Tolkien | 1970\n");
    }

    @Test
    public void whenUserSelectsListBooksListBooksIsCalled() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: Harry Potter | J.K. Rowling | 1995\n" + "2: Lord of the Rings | Tolkien | 1970\n");
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
        when(bufferedReader.readLine()).thenReturn("2", "1", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: List Books\n2: Checkout item\n3: Return a Book\ntype \"Quit\" to end.");
        verify(printStream).println("Thank you! Enjoy the book");
        verify(printStream).println("Thank you! Goodbye");
    }

    @Test
    public void shouldPrintSuccessMessageWhenUserChecksOutBookWithId1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        biblioteca.checkOutItem();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldPrintSuccessMessageWhenUserChecksOutBookWithId2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        biblioteca.checkOutItem();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldPrintErrorMessageWhenUserChecksOutBookWithId3() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3");
        biblioteca.checkOutItem();
        verify(printStream).println("Invalid book ID");
    }

    @Test
    public void bookShouldBecomeUnavailableWhenCheckedOut() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        biblioteca.checkOutItem();
        assertEquals(biblioteca.getBookById(2).isAvailable(), false);
    }

    @Test
    public void shouldPrintErrorIfUserTriesToCheckOutUnavailableBook() throws IOException {
        biblioteca.makeBookUnavailable(2);
        when(bufferedReader.readLine()).thenReturn("2");
        biblioteca.checkOutItem();
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldPrintSuccessMessageWhenUserReturnsCheckedOutBook() throws IOException {
        biblioteca.makeBookUnavailable(2);
        when(bufferedReader.readLine()).thenReturn("3", "2", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: List Books\n2: Checkout item\n3: Return a Book\ntype \"Quit\" to end.");
        verify(printStream).println("Thank you for returning the book.");
        verify(printStream).println("Thank you! Goodbye");

    }

    @Test
    public void shouldPrintErrorMessageWhenUserTriesToReturnAvailableBook() throws IOException {
        biblioteca.makeBookAvailable(2);
        when(bufferedReader.readLine()).thenReturn("3", "2", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: List Books\n2: Checkout item\n3: Return a Book\ntype \"Quit\" to end.");
        verify(printStream).println("That is not a valid book to return.");
        verify(printStream).println("Thank you! Goodbye");

    }

    @Test
    public void bookShouldBeAvailableWhenUserReturnsIt() throws IOException {
        biblioteca.makeBookUnavailable(2);
        when(bufferedReader.readLine()).thenReturn("3", "2", "Quit");
        biblioteca.carryOutMenuSelection();
        assertEquals(biblioteca.getBookById(2).isAvailable(), true);
    }
}
