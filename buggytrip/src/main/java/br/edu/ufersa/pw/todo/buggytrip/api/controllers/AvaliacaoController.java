package br.edu.ufersa.pw.todo.buggytrip.api.controllers;
import com.buggytrip.model.Avaliacao;
import com.buggytrip.service.AvaliacaoService;
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
    public List<Avaliacao> listar() {
        return service.listar();
    }

    @PostMapping
    public Avaliacao salvar(@RequestBody Avaliacao avaliacao) {
        return service.salvar(avaliacao);
    }
}
