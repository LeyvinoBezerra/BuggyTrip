package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.domain.entities.AvaliacaoEntity;
import br.edu.ufersa.pw.todo.buggytrip.domain.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoEntity>> listar() {
        List<AvaliacaoEntity> avaliacoes = service.listar();
        return ResponseEntity.ok(avaliacoes);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoEntity> salvar(@Valid @RequestBody AvaliacaoEntity avaliacao) {
        AvaliacaoEntity nova = service.salvar(avaliacao);
        return ResponseEntity.ok(nova);
    }

}
