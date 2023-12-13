package service;

import dto.UsuarioDTOInput;
import dto.UsuarioDTOOutput;
import model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsuarioService {
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDTOOutput> listar() {
        List<UsuarioDTOOutput> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            usuariosDTO.add(modelMapper.map(usuario, UsuarioDTOOutput.class));
        }
        return usuariosDTO;
    }

    public void inserir(UsuarioDTOInput usuarioDTOInput) {
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        listaUsuarios.add(usuario);
    }

    public void alterar(UsuarioDTOInput usuarioDTOInput) {
        Usuario usuarioAtualizado = modelMapper.map(usuarioDTOInput, Usuario.class);
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == usuarioAtualizado.getId()) {
                listaUsuarios.set(i, usuarioAtualizado);
                break;
            }
        }
    }

    public UsuarioDTOOutput buscar(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return modelMapper.map(usuario, UsuarioDTOOutput.class);
            }
        }
        return null;
    }

    public void excluir(int id) {
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
