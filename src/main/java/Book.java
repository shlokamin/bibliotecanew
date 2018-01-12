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

    public String toString() {
        return (title + " | " + author + " | " + yearPublished);

    }
}
