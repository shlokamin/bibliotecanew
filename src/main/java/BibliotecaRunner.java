import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaRunner {
    private static Biblioteca biblioteca;

    public static void main(String[] args) throws IOException {
        Inventory books = new Inventory();
        books.addBook("Harry Potter", "J.K. Rowling", "1995");
        books.addBook("The Chamber of Secrets", "J.K. Rowling", "1996");
        books.addBook("The Prisoner of Azkaban", "J.K. Rowling", "1998");
        biblioteca = new Biblioteca(System.out, new BufferedReader(new InputStreamReader(System.in)), books);
        biblioteca.init();
    }
}
