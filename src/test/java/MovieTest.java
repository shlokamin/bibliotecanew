import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MovieTest {

    @Test
    public void shouldFormatMovieDetailsToString() {
        Movie movie = new Movie("Harry Potter", "David Yates", "1995",10, 1);
        String movieDetails = "[available] 1: Harry Potter | David Yates | 1995 | 10";
        assertEquals(movie.toString(), movieDetails);
    }
}