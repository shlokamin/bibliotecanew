import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mockito.Mockito.*;




public class MainMenuTests {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        menu  = new Menu(printStream,new String[] {"List Books"},new Scanner(System.in));
    }


    @Test
    public void menuShouldDisplayOptions(){
        menu.displayOptions();
        verify(printStream).println("1: List Books");
    }
}
