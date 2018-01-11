import java.io.PrintStream;

public class Book {
    private String title;
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void displayDetails(PrintStream printStream) {
        printStream.println(title + " | " + author + " | " + yearPublished);

    }
}
