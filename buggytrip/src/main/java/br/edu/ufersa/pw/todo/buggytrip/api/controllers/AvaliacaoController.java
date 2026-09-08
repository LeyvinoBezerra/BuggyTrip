package br.edu.ufersa.pw.todo.buggytrip.api.controllers;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.AvaliacaoEntity;
import br.edu.ufersa.pw.todo.buggytrip.domain.service.AvaliacaoService;
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
    public List<AvaliacaoEntity> listar() {
        return service.listar();
    }

    @PostMapping
    public AvaliacaoEntity salvar(@RequestBody AvaliacaoEntity avaliacao) {
        return service.salvar(avaliacao);
    }
}
