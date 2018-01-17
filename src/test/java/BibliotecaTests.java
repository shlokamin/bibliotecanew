import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

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
        Inventory media = new Inventory();
        media.addBook("Harry Potter", "J.K. Rowling", "1995");
        media.addBook("Lord of the Rings", "Tolkien", "1970");
        media.addMovie("Twilight", "Stephanie Meyers", "2005", 1);
        media.addMovie("Breaking Dawn", "Stephanie Meyers", "2010", 1);
        biblioteca = new Biblioteca(printStream, bufferedReader, media);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenAppStarts(){
        String message = "Welcome to Biblioteca";
        biblioteca.displayWelcomeMessage();
        verify(printStream).println("Welcome to Biblioteca");
    }

    @Test
    public void shouldDisplayBookDetails() {
        biblioteca.displayBooks();
        verify(printStream).println("OK, here are the items:");
        verify(printStream).println("[available] 1: Harry Potter | J.K. Rowling | 1995\n" +
                                    "[available] 2: Lord of the Rings | Tolkien | 1970\n" +
                                    "[available] 3: Twilight | Stephanie Meyers | 2005 | 1\n" +
                                    "[available] 4: Breaking Dawn | Stephanie Meyers | 2010 | 1\n");    }

    @Test
    public void whenUserSelectsListBooksListBooksIsCalled() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: Display Inventory\n2: Checkout item\n3: Return an Item\ntype \"Quit\" to end.");
        verify(printStream).println("[available] 1: Harry Potter | J.K. Rowling | 1995\n" +
                                    "[available] 2: Lord of the Rings | Tolkien | 1970\n" +
                                    "[available] 3: Twilight | Stephanie Meyers | 2005 | 1\n" +
                                    "[available] 4: Breaking Dawn | Stephanie Meyers | 2010 | 1\n");
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
        verify(printStream).println("1: Display Inventory\n2: Checkout item\n3: Return an Item\ntype \"Quit\" to end.");
        verify(printStream).println("Check out an item by typing in its id:");
        verify(printStream).println("Thank you! Enjoy the item.");
        verify(printStream).println("Thank you! Goodbye");
    }

    @Test
    public void shouldPrintSuccessMessageWhenUserChecksOutBookWithId1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        biblioteca.checkOutItem();
        verify(printStream).println("Check out an item by typing in its id:");
        verify(printStream).println("Thank you! Enjoy the item.");
    }

    @Test
    public void shouldPrintSuccessMessageWhenUserChecksOutBookWithId2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        biblioteca.checkOutItem();
        verify(printStream).println("Check out a book by typing in its id:");
        verify(printStream).println("Thank you! Enjoy the item.");
    }

    @Test
    public void shouldPrintErrorMessageWhenUserChecksOutMediaWithId7() throws IOException {
        when(bufferedReader.readLine()).thenReturn("7");
        biblioteca.checkOutItem();
        verify(printStream).println("Check out an item by typing in its id:");
        verify(printStream).println("Invalid item ID");
    }

    @Test
    public void bookShouldBecomeUnavailableWhenCheckedOut() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        biblioteca.checkOutItem();
        assertEquals(biblioteca.getBooks().getMediaById(2).isAvailable(), false);
    }

    @Test
    public void shouldPrintErrorIfUserTriesToCheckOutUnavailableBook() throws IOException {
        biblioteca.makeMediaUnavailable(2);
        when(bufferedReader.readLine()).thenReturn("2");
        biblioteca.checkOutItem();
        verify(printStream).println("Check out an item by typing in its id:");
        verify(printStream).println("That item is not available.");
    }

    @Test
    public void shouldPrintSuccessMessageWhenUserReturnsCheckedOutBook() throws IOException {
        biblioteca.makeMediaUnavailable(2);
        when(bufferedReader.readLine()).thenReturn("3", "2", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: Display Inventory\n2: Checkout item\n3: Return an Item\ntype \"Quit\" to end.");
        verify(printStream).println("Return an item by typing in its id:");
        verify(printStream).println("Thank you for returning the item.");
        verify(printStream).println("Thank you! Goodbye");
    }

    @Test
    public void shouldPrintSuccessMessageWhenUserReturnsCheckedOutMovie() throws IOException {
        biblioteca.makeMediaUnavailable(4);
        when(bufferedReader.readLine()).thenReturn("3", "4", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: Display Inventory\n2: Checkout item\n3: Return an Item\ntype \"Quit\" to end.");
        verify(printStream).println("Return an item by typing in its id:");
        verify(printStream).println("Thank you for returning the item.");
        verify(printStream).println("Thank you! Goodbye");
    }

    @Test
    public void shouldPrintErrorMessageWhenUserTriesToReturnAvailableBook() throws IOException {
        biblioteca.makeMediaAvailable(2);
        when(bufferedReader.readLine()).thenReturn("3", "2", "Quit");
        biblioteca.carryOutMenuSelection();
        verify(printStream).println("1: Display Inventory\n2: Checkout item\n3: Return an Item\ntype \"Quit\" to end.");
        verify(printStream).println("Return an item by typing in its id:");
        verify(printStream).println("That is not a valid item to return.");
        verify(printStream).println("Thank you! Goodbye");
    }

    @Test
    public void bookShouldBeAvailableWhenUserReturnsIt() throws IOException {
        biblioteca.makeMediaUnavailable(2);
        when(bufferedReader.readLine()).thenReturn("3", "2", "Quit");
        biblioteca.carryOutMenuSelection();
        assertEquals(biblioteca.getBooks().getMediaById(2).isAvailable(), true);
    }
}