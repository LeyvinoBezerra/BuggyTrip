
package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request.UsuarioPostRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request.UsuarioPutRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioGetResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioPostResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioPutResponse;
import br.edu.ufersa.pw.todo.buggytrip.domain.mappers.UsuarioMapper;
import br.edu.ufersa.pw.todo.buggytrip.domain.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/{userId}/usuario")
@Log4j2
@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioPostResponse> salvar(
            @RequestBody @Valid UsuarioPostRequest usuario) {
        log.info("Salvando usuário {}", usuario);
        var usuarioSaved = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioPutResponse> atualizar(
            @PathVariable Long id, @RequestBody @Valid UsuarioPutRequest usuario) {
        log.info("Atualizando usuário {}", id);
        var usuarioUpdated = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {
        log.info("Excluindo usuário {}", id);
        usuarioService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGetResponse> buscarPorId(
            @PathVariable Long id) {
        log.info("Buscando usuário {}", id);
        var usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioGetResponse>> listarTodos() {
        log.info("Listando usuários");
        var usuarios = usuarioService.listar();
        return ResponseEntity.ok(usuarios);
    }
}
