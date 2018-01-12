import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainMenuTests {

    @Test
    public void menuShouldDisplay(){
        String[] options = {"List Books"};
        PrintStream printStream = mock(PrintStream.class);
        Menu menu = new Menu(printStream,options);


        menu.displayOptions();

        verify(printStream).println("1: List Books");

    }


}
