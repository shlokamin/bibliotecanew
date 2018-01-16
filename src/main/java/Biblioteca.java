import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private ArrayList<Book> books;
    private Menu menu;

    public Biblioteca(PrintStream printStream, BufferedReader bufferedReader, ArrayList<Book> books) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.books = books;
        String[] options = new String[] {"List Books", "Checkout item"};
        this.menu = new Menu(printStream,bufferedReader,options);
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

    public void checkOutItem() {
        printStream.println("Checkout that item");
    }

    public void init() throws IOException {
        displayWelcomeMessage();
        printStream.println("Menu Options: ");
        carryOutMenuSelection();
    }

    public void quit() throws IOException {
        printStream.println("Thank you! Goodbye");
        bufferedReader.close();
        printStream.close();
    }

    public void carryOutMenuSelection() throws IOException {
//        menu.displayOptions();
        String input = menu.getUserOption();
        while (!(input.equals("Quit"))) {
            if (input.equals("1")) listBooks();
            else if (input.equals("2")) checkOutItem();
            else return;
            input = menu.getUserOption();
        }
        quit();
    }

    public static void main(String[] args) throws IOException {
        Book book = new Book("Harry Potter", "J.K. Rowling", "1995");
        Book book2 = new Book("The Chamber of Secrets", "J.K. Rowling", "1996");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        Biblioteca biblioteca = new Biblioteca(System.out, new BufferedReader(new InputStreamReader(System.in)), books);
        biblioteca.init();

    }

}
