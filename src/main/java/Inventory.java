import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Media> media;
    private int idCounter;

    public
    Inventory() {
        media = new ArrayList<>();
        idCounter = 1;
    }

    public void addBook(String title, String author, String year) {
        media.add(new Book(title, author, year, idCounter));
        idCounter++;
    }

    public void addMovie(String name, String director, String year, int rating) {
        media.add(new Movie(name, director, year, rating, idCounter));
        idCounter++;
    }

    public List<Media> getMedia() {
        return media;
    }

    public Media getMediaById(int id) {
        return media.get(id-1);
    }

    public int getSize() {
        return media.size();
    }

    public boolean isValidId(int id) {
        return id > 0 && id <= media.size();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Media medium : media) {
            s.append(medium.toString() + "\n");
        }
        return s.toString();
    }
}
