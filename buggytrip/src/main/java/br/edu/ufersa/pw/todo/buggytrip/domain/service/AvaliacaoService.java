package br.edu.ufersa.pw.todo.buggytrip.domain.service;

import com.buggytrip.model.Avaliacao;
import com.buggytrip.repository.AvaliacaoRepository;

public class AvaliacaoService {
    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    public List<Avaliacao> listar() {
        return repository.findAll();
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }
}
