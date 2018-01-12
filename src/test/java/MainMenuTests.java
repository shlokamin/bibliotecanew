import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;




public class MainMenuTests {
    private PrintStream printStream;
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        Book book = new Book("Harry Potter", "J.K. Rowling", "1995");
        Book book2 = new Book("The Chamber of Secrets", "J.K. Rowling", "1996");

        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        biblioteca = new Biblioteca(printStream, books);
    }


    @Test
    public void menuShouldDisplay(){
        biblioteca.getMenu().displayOptions();
        verify(printStream).println("1: List Books");
    }

    @Test
    public void whenUserSelectsListBooksListBooksIsCalled(){
        biblioteca.carryOutMenuSelection(1);
        verify(printStream).println("Harry Potter | J.K. Rowling | 1995\n" + "The Chamber of Secrets | J.K. Rowling | 1996\n");
    }


}
