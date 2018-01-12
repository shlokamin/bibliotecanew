import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;




public class MainMenuTests {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        menu  = new Menu(printStream,bufferedReader,new String[] {"List Books"});
    }


    @Test
    public void menuShouldDisplayOptions(){
        menu.displayOptions();
        verify(printStream).println("1: List Books");
    }

    @Test
    public void shouldReceiveUserInput()  throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        String input = menu.getUserOption();
        assertEquals(input, "1");
    }


    @Test
    public void shouldThrowErrorIfUserInputIsNotNumeric() throws IOException {
        when(bufferedReader.readLine()).thenReturn("b");
        menu.getUserOption();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldThrowErrorIfUserNumericInputIsOutOfOptionsRange() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3");

        menu.getUserOption();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldKeepAskingForUserInputIfInputIsInvalid() throws IOException {
        when(bufferedReader.readLine()).thenReturn("b");
        when(bufferedReader.readLine()).thenReturn("3");
        when(bufferedReader.readLine()).thenReturn("1");

        String option = menu.getUserOption();
        int optionNum = Integer.parseInt(option);
        assertEquals(optionNum,1);
    }
}
