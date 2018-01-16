public class Movie extends Media {
    private String director;
    private int rating;

    public Movie(String title, String director, String year, int rating, int id) {
        super(title, year, id);
        this.rating = rating;
        this.director = director;
    }

    @Override
    public String toString() {
        String available = availability ? "available" : "unavailable";
        return ("[" + available + "] " + id + ": " + title + " | " + director + " | " + yearPublished + " | " + rating);
    }

    public int getRating() {
        return rating;
    }
}
