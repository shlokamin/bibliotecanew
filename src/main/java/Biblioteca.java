import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {
    private PrintStream printStream;
    private ArrayList<Book> books;

    public Biblioteca(PrintStream printStream, ArrayList<Book> books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void listBooks() {
        for (Book book : books) {
            book.displayDetails(printStream);
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(System.out,new ArrayList<Book>());
        biblioteca.init();
    }

    public void init() {
        displayWelcomeMessage();
        listBooks();
    }
}
