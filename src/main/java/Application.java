import com.fasterxml.jackson.databind.ObjectMapper;
import controller.UsuarioController;
import service.UsuarioService;


import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioController usuarioController = new UsuarioController(usuarioService, objectMapper);
    }
}

