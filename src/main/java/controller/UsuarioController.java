package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UsuarioDTOInput;
import service.UsuarioService;

import static spark.Spark.*;

public class UsuarioController {
    private UsuarioService usuarioService;
    private ObjectMapper objectMapper;

    public UsuarioController(UsuarioService usuarioService, ObjectMapper objectMapper) {
        this.usuarioService = usuarioService;
        this.objectMapper = objectMapper;
        respostaRequisicoes();
    }

    private void respostaRequisicoes() {
        get("/usuarios", (req, res) -> {
            res.type("application/json");
            return objectMapper.writeValueAsString(usuarioService.listar());
        });

        get("/usuarios/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return objectMapper.writeValueAsString(usuarioService.buscar(id));
        });

        delete("/usuarios/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            usuarioService.excluir(id);
            res.status(204);
            return "";
        });

        post("/usuarios", (req, res) -> {
            res.type("application/json");
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(req.body(), UsuarioDTOInput.class);
            usuarioService.inserir(usuarioDTOInput);
            res.status(201);
            return "";
        });

        put("/usuarios", (req, res) -> {
            res.type("application/json");
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(req.body(), UsuarioDTOInput.class);
            usuarioService.alterar(usuarioDTOInput);
            res.status(200);
            return "";
        });
    }
}
