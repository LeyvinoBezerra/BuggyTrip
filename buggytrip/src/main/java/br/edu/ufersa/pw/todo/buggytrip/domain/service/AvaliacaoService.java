package br.edu.ufersa.pw.todo.buggytrip.domain.service;

import br.edu.ufersa.pw.todo.buggytrip.domain.entities.AvaliacaoEntity;
import br.edu.ufersa.pw.todo.buggytrip.domain.repositories.AvaliacaoRepository;


import java.util.List;

public class AvaliacaoService {
    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    public List<AvaliacaoEntity> listar() {
        return repository.findAll();
    }

    public AvaliacaoEntity salvar(AvaliacaoEntity avaliacao) {
        return repository.save(avaliacao);
    }
}
