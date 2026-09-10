package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.api.dto.UsuarioDTO;
import br.edu.ufersa.pw.todo.buggytrip.api.entity.UsuarioEntity;
import br.edu.ufersa.pw.todo.buggytrip.api.record.UsuarioPatch;
import br.edu.ufersa.pw.todo.buggytrip.api.record.UsuarioUpdate;
import br.edu.ufersa.pw.todo.buggytrip.api.record.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/{userId}/usuarios")
public class UsuarioController {

    @GetMapping
    public <UsuarioResponse> ResponseEntity<List<UsuarioResponse>> listar(
            @PathVariable Long userId) {
        // lógica para listar usuários de um determinado userId
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/{usuarioId}")
    public <UsuarioResponse> ResponseEntity<UsuarioResponse> buscarPorId(
            @PathVariable Long userId,
            @PathVariable Long usuarioId) {
        // lógica para buscar usuário específico
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public <UsuarioEntity> ResponseEntity<UsuarioEntity> salvar(
            @RequestBody UsuarioDTO dto,
            @PathVariable Long userId,
            UriComponentsBuilder uriBuilder) {
        // lógica para salvar novo usuário
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponse> atualizar(
            @PathVariable Long userId,
            @PathVariable Long usuarioId,
            @RequestBody UsuarioUpdate dto) {
        // lógica para atualizar usuário
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponse> alterarParcial(
            @PathVariable Long userId,
            @PathVariable Long usuarioId,
            @RequestBody UsuarioPatch dto) {
        // lógica para atualização parcial
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> remover(
            @PathVariable Long userId,
            @PathVariable Long usuarioId) {
        // lógica para remover usuário
        return ResponseEntity.noContent().build();
    }
}
