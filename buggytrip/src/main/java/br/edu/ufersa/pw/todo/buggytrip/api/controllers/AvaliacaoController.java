package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Avaliacao;
import br.edu.ufersa.pw.todo.buggytrip.domain.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/{userId}/avaliacao")
@Validated
public class AvaliacaoController {

    private final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService service) {
        this.service = service;
    }

    // Listar todas as avaliações
    @GetMapping
    public ResponseEntity<List<Avaliacao>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // Buscar avaliação por ID
    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Salvar nova avaliação
    @PostMapping
    public ResponseEntity<Avaliacao> salvar(@Valid @RequestBody AvaliacaoDTO dto) {
        Avaliacao nova = service.salvar(dto);
        return ResponseEntity.ok(nova);
    }

    // Atualizar avaliação (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizar(@PathVariable Long id, @Valid @RequestBody AvaliacaoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // Atualizar parcialmente avaliação (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizarParcial(@PathVariable Long id, @RequestBody AvaliacaoDTO dto) {
        return ResponseEntity.ok(service.atualizarParcial(id, dto));
    }

    // Remover avaliação
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}

