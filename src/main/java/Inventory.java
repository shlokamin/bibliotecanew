import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private ArrayList<Book> books;
    private int idCounter;

    public
    Inventory() {
        books = new ArrayList<>();
        idCounter = 1;
    }

    public void addBook(String title, String author, String year) {
        books.add(new Book(title, author, year, idCounter));
        idCounter++;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.get(id-1);
    }

    public int getSize() {
        return books.size();
    }

    public boolean isValidId(int id) {
        return id > 0 && id <= books.size();
    }

}
