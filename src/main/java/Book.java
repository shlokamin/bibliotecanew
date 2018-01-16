public class Book extends Media {
    private String author;

    public Book(String title, String author, String year, int id) {
        super(title, year, id);
        this.author = author;
    }

    @Override
    public String toString() {
        String available = availability ? "available" : "unavailable";
        return ("[" + available + "] " + id + ": " + title + " | " + author + " | " + yearPublished);
    }

}
