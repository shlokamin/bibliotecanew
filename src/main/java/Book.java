import java.io.PrintStream;

public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private int id;
    private boolean availability = true;

    public Book(String title, String author, String yearPublished, int id) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.id = id;
    }

    public String toString() {
        return (id + ": " + title + " | " + author + " | " + yearPublished);
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

    public boolean equals(Book book) {
        return book.getId() == this.id;
    }

}
