import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EndpointTest {

    @Test
    public void testListagemUsuarios() throws IOException {
        URL url = new URL("http://localhost:4567/usuarios");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        int responseCode = conexao.getResponseCode();
        assertEquals(200, responseCode);
    }
}
