import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;




public class MainMenuTests {

    @Test
    public void menuShouldDisplay(){
        String[] options = {"List Books"};
        PrintStream printStream = mock(PrintStream.class);
        Menu menu = new Menu(printStream,options);


        menu.displayOptions();

        verify(printStream).println("1: List Books");

    }
//    @Test
//    public void whenUserSelectsListBooksListBooksIsCalled(){
//
//        Biblioteca biblioteca = mock(Biblioteca.class);
//        String[] options = {"List Books"};
//        PrintStream printStream = mock(PrintStream.class);
//        Menu menu = new Menu(printStream,options);
//        menu.requestOptionSelection();
//        verify(biblioteca.listBooks();
//
//
//    }


}
