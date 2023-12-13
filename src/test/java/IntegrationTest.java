import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import dto.UsuarioDTOInput;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    @Test
    public void testInsercaoUsuarioAleatorio() throws IOException {
        URL randomUserApiUrl = new URL("https://randomuser.me/api/");
        HttpURLConnection randomUserApiConnection = (HttpURLConnection) randomUserApiUrl.openConnection();
        randomUserApiConnection.setRequestMethod("GET");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode randomUserData = objectMapper.readTree(randomUserApiConnection.getInputStream());
        JsonNode userNode = randomUserData.get("results").get(0);

        UsuarioDTOInput usuarioDTOInput = new UsuarioDTOInput();
        usuarioDTOInput.setNome(userNode.get("name").get("first").asText());
        usuarioDTOInput.setSenha("generated_password");

        URL yourApiUrl = new URL("http://localhost:4567/usuarios");
        HttpURLConnection yourApiConnection = (HttpURLConnection) yourApiUrl.openConnection();
        yourApiConnection.setRequestMethod("POST");
        yourApiConnection.setDoOutput(true);

        objectMapper.writeValue(yourApiConnection.getOutputStream(), usuarioDTOInput);

        int responseCode = yourApiConnection.getResponseCode();
        assertEquals(201, responseCode);
    }
}
