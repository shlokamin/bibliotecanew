import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaRunner {

    public static void main(String[] args) throws IOException {
        Biblioteca biblioteca = new Biblioteca(System.out, new BufferedReader(new InputStreamReader(System.in)));
        biblioteca.init();
    }
}
