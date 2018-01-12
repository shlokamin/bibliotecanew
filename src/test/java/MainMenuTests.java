import org.junit.Test;

public class MainMenuTests {

    @Test
    public void menuShouldDisplay(){
        String[] options = {"List Books"};
        Menu menu = new Menu(options);

        String expectedOutput = "List Books";

    }
}
