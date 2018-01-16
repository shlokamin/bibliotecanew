import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Biblioteca {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Inventory books;
    private Menu menu;

    public Biblioteca(PrintStream printStream, BufferedReader bufferedReader, Inventory books) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.books = books;
        String[] options = new String[] {"List Books", "Checkout item", "Return a Book"};
        this.menu = new Menu(printStream,bufferedReader,options);
    }

    public Inventory getBooks() {
        return books;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void listBooks() {
        printStream.println("OK, here are the books:");
        StringBuilder s = new StringBuilder();
        for (Book book : books.getBooks()) {
            s.append(book.toString() + "\n");
        }
        printStream.println(s.toString());
    }

    public void checkOutItem() {
        printStream.println("Check out a book by typing in the book id:");
        int bookId = getValidUserInput();
        if (books.isValidId(bookId)) {
            if (!books.getBookById(bookId).isAvailable()) {
                printStream.println("That book is not available.");
            } else {
                makeBookUnavailable(bookId);
                printStream.println("Thank you! Enjoy the book");
            }
        } else {
            printStream.println("Invalid book ID");
        }
        listBooks();
    }

    private void returnBook() {
        printStream.println("Return a book by typing in the book id:");
        int bookId = getValidUserInput();
        if (books.isValidId(bookId)) {
            if (books.getBookById(bookId).isAvailable()) {
                printStream.println("That is not a valid book to return.");
            } else {
                makeBookAvailable(bookId);
                printStream.println("Thank you for returning the book.");
            }
        } else {
            printStream.println("Invalid book ID");
        }
        listBooks();
    }

    private int getValidUserInput() {
        String input;
        while (true) {
            try {
                input = bufferedReader.readLine();
                try {
                    return Integer.parseInt(input);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    printStream.println("Must be a valid integer");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeBookUnavailable(int bookId) {
        books.getBookById(bookId).setUnavailable();
    }

    public void makeBookAvailable(int bookId) {
        books.getBookById(bookId).setAvailable();
    }

    public void init() throws IOException {
        displayWelcomeMessage();
        printStream.println("Select a Menu Item: ");
        carryOutMenuSelection();
    }

    public void quit() throws IOException {
        printStream.println("Thank you! Goodbye");
        bufferedReader.close();
        printStream.close();
    }

    public void carryOutMenuSelection() throws IOException {
        menu.displayOptions();
        String input = menu.getUserOption();
        while (!(input.equals("Quit"))) {
            if (input.equals("1")) listBooks();
            else if (input.equals("2")) checkOutItem();
            else if (input.equals("3")) returnBook();
            else return;
            printStream.println("Make another menu selection");
            input = menu.getUserOption();
        }
        quit();
    }

    public static void main(String[] args) throws IOException {
        Inventory books = new Inventory();
        books.addBook("Harry Potter", "J.K. Rowling", "1995");
        books.addBook("The Chamber of Secrets", "J.K. Rowling", "1996");
        books.addBook("The Prisoner of Azkaban", "J.K. Rowling", "1998");
        Biblioteca biblioteca = new Biblioteca(System.out, new BufferedReader(new InputStreamReader(System.in)), books);
        biblioteca.init();
    }
}
