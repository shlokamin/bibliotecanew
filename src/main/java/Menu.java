import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
    private final String[] options;
    private final PrintStream printStream;
    private final Scanner scanner;

    public Menu(PrintStream printStream, String[] options, Scanner scanner) {
        this.options = options;
        this.printStream = printStream;
        this.scanner = scanner;

    }
    
    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            printStream.println(i+1 + ": " + options[i]);
        }
    }

    public int getUserOption() {
        displayOptions();
        return 1;
//        return scanner.nextInt();
    }
}
