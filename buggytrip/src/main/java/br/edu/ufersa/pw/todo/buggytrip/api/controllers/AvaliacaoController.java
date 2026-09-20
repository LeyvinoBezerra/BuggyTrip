package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Avaliacao.request.AvaliacaoPostRequest;
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

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Avaliacao> salvar(@Valid @RequestBody AvaliacaoPostRequest dto) {
        Avaliacao nova = service.salvar(dto);
        return ResponseEntity.ok(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizar(@PathVariable Long id, @Valid @RequestBody AvaliacaoPostRequest dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizarParcial(@PathVariable Long id, @RequestBody AvaliacaoPostRequest dto) {
        return ResponseEntity.ok(service.atualizarParcial(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}

