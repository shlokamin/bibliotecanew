import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Biblioteca {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Inventory medias;
    private Menu menu;

    public Biblioteca(PrintStream printStream, BufferedReader bufferedReader, Inventory medias) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;

        String[] options = new String[] {"Display Inventory", "Checkout item", "Return an Item"};
        this.menu = new Menu(printStream,bufferedReader,options);
        this.medias = medias;
    }

    public Inventory getBooks() {
        return medias;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void displayBooks(){
        printStream.println("OK, here are the items:");
        printStream.println(medias.toString());
    }

    public void checkOutItem() {
        printStream.println("Check out an item by typing in its id:");
        int mediaId = getValidUserInput();
        if (medias.isValidId(mediaId)) {
            if (!medias.getMediaById(mediaId).isAvailable()) {
                printStream.println("That item is not available.");
            } else {
                makeMediaUnavailable(mediaId);
                printStream.println("Thank you! Enjoy the item.");
            }
        } else {
            printStream.println("Invalid media ID");
        }
        displayBooks();
    }

    private void returnBook() {
        printStream.println("Return an item by typing in its id:");
        int mediaId = getValidUserInput();
        if (medias.isValidId(mediaId)) {
            if (medias.getMediaById(mediaId).isAvailable()) {
                printStream.println("That is not a valid item to return.");
            } else {
                makeMediaAvailable(mediaId);
                printStream.println("Thank you for returning the item.");
            }
        } else {
            printStream.println("Invalid item ID");
        }
        displayBooks();
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

    public void makeMediaUnavailable(int mediaId) {
        medias.getMediaById(mediaId).setUnavailable();
    }

    public void makeMediaAvailable(int mediaId) {
        medias.getMediaById(mediaId).setAvailable();
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
            if (input.equals("1")) displayBooks();
            else if (input.equals("2")) checkOutItem();
            else if (input.equals("3")) returnBook();
            else return;
            printStream.println("Make another menu selection");
            input = menu.getUserOption();
        }
        quit();
    }


}
