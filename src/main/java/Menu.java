import java.io.PrintStream;

public class Menu {
    private final String[] options;
    private final PrintStream printStream;

    public Menu(PrintStream printStream, String[] options) {
        this.options = options;
        this.printStream = printStream;

    }
    
    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            printStream.println(i+1 + ": " + options[i]);
        }
    }
}
