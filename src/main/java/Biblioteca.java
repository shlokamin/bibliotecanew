import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private PrintStream printStream;
    private ArrayList<Book> books;
    private Menu menu;
    private BufferedReader bufferedReader;


    public Biblioteca(PrintStream printStream, BufferedReader bufferedReader, ArrayList<Book> books) {
        this.printStream = printStream;
        this.books = books;
        this.bufferedReader = bufferedReader;
        this.menu = new Menu(printStream,bufferedReader,new String[] {"List Books"});
    }

    public Menu getMenu() {
        return menu;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void listBooks() {
        StringBuilder s = new StringBuilder();
        for (Book book : books) {
            s.append(book.toString() + "\n");
        }
        printStream.println(s.toString());
    }

    public void init() {
        displayWelcomeMessage();
        listBooks();
    }

    public void carryOutMenuSelection() {
        menu.displayOptions();
        String input = menu.getUserOption();
        if(input.equals("1")){
            listBooks();
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Harry Potter", "J.K. Rowling", "1995");
        Book book2 = new Book("The Chamber of Secrets", "J.K. Rowling", "1996");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        Biblioteca biblioteca = new Biblioteca(System.out, new BufferedReader(new InputStreamReader(System.in)), books);
        biblioteca.init();

    }
}
