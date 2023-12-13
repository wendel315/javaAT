import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UsuarioDTOInput;
import org.junit.Before;
import org.junit.Test;
import service.UsuarioService;
import static org.junit.Assert.assertEquals;

public class ServiceTest {

    private UsuarioService usuarioService;

    @Before
    public void setUp() {
        usuarioService = new UsuarioService();
    }

    @Test
    public void testInsercaoUsuario() {
        UsuarioDTOInput usuarioDTOInput = new UsuarioDTOInput();
        usuarioDTOInput.setNome("Usuario");
        usuarioDTOInput.setSenha("123");

        usuarioService.inserir(usuarioDTOInput);

        assertEquals(1, usuarioService.listar().size());
    }
}
