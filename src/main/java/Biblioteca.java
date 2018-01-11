import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {
    private PrintStream printStream;
    private ArrayList<Book> books;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
        books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995"));
        books.add(new Book("Lord of the Rings", "Tolkien", "1970"));
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void listBooks() {
        for (Book book : books) {
            book.displayDetails(printStream);
        }

    }
}
