import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
    private final String[] options;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, String[] options) {
        this.options = options;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }
    
    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            printStream.println(i+1 + ": " + options[i]);
        }
    }

    public String getUserOption() {
        //displayOptions();
        String input = null;

        while(true){
            try {
                input = bufferedReader.readLine();
                if (input.equals("Quit")) return input;
                try {
                    int optionNumber = Integer.parseInt(input);
                    if (optionNumber < 1 || optionNumber > options.length) {
                        printStream.println("Select a valid option!");
                    }
                    else{
                        return input;
                    }
                } catch (NumberFormatException e) {
                    printStream.println("Select a valid option!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public int getOptionsLength() {
        return options.length;
    }
}
