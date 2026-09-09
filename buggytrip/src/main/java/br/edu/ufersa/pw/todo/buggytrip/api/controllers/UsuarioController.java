package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioDTO;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioPatch;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioUpdate;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.UsuarioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;


@RequestMapping("/api/v1/user/{userId}/usuarios")
public class UsuarioController {
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar(
            @pathVariable Long userId) {
        return null;
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponse> buscarPorId(
            @PathVariable Long userId,
            @PathVariable Long usuarioId) {
        return null;
    }

    @PostMapping
    public UsuarioEntity salvar(
            @RequestBody UsuarioDTO dto,
            @PathVariable String userId,
            UriComponentsBuilder uriBuilder) {
        return null;
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<UsuarioResponse> atualizar(
            @PathVariable Long userId,
            @PathVariable Long UsuarioId,
            @RequestBody UsuarioUpdate dto) {
        return null;
    }


    @PatchMapping("/{todoId}")
    public ResponseEntity<UsuarioResponse> alterarParcial(
            @PathVariable Long userId,
            @PathVariable Long UsuarioId,
            @RequestBody UsuarioPatch dto) {
        return null;
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> remover(
            @PathVariable Long userId,
            @PathVariable Long todoId) {

        return null;
    }
}