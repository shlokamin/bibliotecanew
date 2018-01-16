import java.io.PrintStream;

public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private int id;
    private boolean availability = true;
    private static int idCounter = 1;

    public Book(String title, String author, String yearPublished, int id) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.id = id;
    }

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        id = idCounter;
        idCounter++;
    }

    public String toString() {
        String available = availability ? "available" : "unavailable";
        return ("[" + available + "] " + id + ": " + title + " | " + author + " | " + yearPublished);
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return availability;
    }


    public void setUnavailable() {
        availability = false;
    }

    public void setAvailable() {
        availability = true;
    }
}
