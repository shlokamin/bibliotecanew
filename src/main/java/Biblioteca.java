import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {
    private PrintStream printStream;
    private ArrayList<String> books;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
        books = new ArrayList<>();
        books.add("Harry Potter");
        books.add("Lord of the Rings");
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void listBooks() {
        //String allBooks;

        for (String book : books) {
            printStream.println(book);
        }

        //printStream.

    }
}
