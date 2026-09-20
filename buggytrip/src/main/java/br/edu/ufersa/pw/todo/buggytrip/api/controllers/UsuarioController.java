
package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioPostRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioPutRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioGetResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioPutResponse;
import br.edu.ufersa.pw.todo.buggytrip.domain.service.UsuarioService;
import br.edu.ufersa.pw.todo.buggytrip.domain.mappers.UsuarioMapper;

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
        var usuarioToSave = usuarioMapper.toUsuario(usuario);
        var usuarioSaved = usuarioService.salvar(usuarioToSave);
        var response = usuarioMapper.toUsuarioPostResponse(usuarioSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioPutResponse> atualizar(
            @PathVariable Long id, @RequestBody @Valid UsuarioPutRequest usuario) {
        log.info("Atualizando usuário {}", id);
        var usuarioToUpdate = usuarioMapper.toUsuario(usuario);
        usuarioToUpdate.setId(id);
        var usuarioUpdated = usuarioService.atualizar(usuarioToUpdate);
        var response = usuarioMapper.toUsuarioPutResponse(usuarioUpdated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {
        log.info("Excluindo usuário {}", id);
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGetResponse> buscarPorId(
            @PathVariable Long id) {
        log.info("Buscando usuário {}", id);
        var usuario = usuarioService.findById(id);
        var response = usuarioMapper.toUsuarioGetResponse(usuario);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioGetResponse>> listarTodos() {
        log.info("Listando usuários");
        var usuarios = usuarioService.listarTodos();
        var response = usuarioMapper.toUsuarioGetResponseList(usuarios);
        return ResponseEntity.ok(response);
    }
}
