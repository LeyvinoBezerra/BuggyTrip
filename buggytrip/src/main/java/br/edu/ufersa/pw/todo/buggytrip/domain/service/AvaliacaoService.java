package br.edu.ufersa.pw.todo.buggytrip.domain.service;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.AvaliacaoDTO;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Avaliacao;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Usuario;
import br.edu.ufersa.pw.todo.buggytrip.domain.repositories.AvaliacaoRepository;
import br.edu.ufersa.pw.todo.buggytrip.domain.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public AvaliacaoService(
            AvaliacaoRepository repository,
            UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Avaliacao> listar() {
        return repository.findAll();
    }

    public Avaliacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Avaliação não encontrada"));
    }

    public Avaliacao salvar(AvaliacaoDTO dto) {
        return repository.save(toEntity(dto));
    }

    public Avaliacao atualizar(Long id, AvaliacaoDTO dto) {
        Avaliacao avaliacao = buscarPorId(id);
        copy(dto, avaliacao);
        return repository.save(avaliacao);
    }

    public void remover(Long id) {
        Avaliacao avaliacao = buscarPorId(id);
        repository.delete(avaliacao);
    }

    private Avaliacao toEntity(AvaliacaoDTO dto) {
        Avaliacao avaliacao = new Avaliacao();
        copy(dto, avaliacao);
        return avaliacao;
    }

    private void copy(AvaliacaoDTO dto, Avaliacao avaliacao) {
        avaliacao.setSeguranca(dto.getSeguranca());
        avaliacao.setConhecimentoRoteiro(dto.getConhecimentoRoteiro());
        avaliacao.setConfortoVeiculo(dto.getConfortoVeiculo());
        avaliacao.setSimpatiaMotorista(dto.getSimpatiaMotorista());
        avaliacao.setExperienciaGeral(dto.getExperienciaGeral());
        avaliacao.setAdaptabilidade(dto.getAdaptabilidade());
        avaliacao.setParadasInteressantes(dto.getParadasInteressantes());
        avaliacao.setDiferencial(dto.getDiferencial());
        avaliacao.setFeedback(dto.getFeedback());
        avaliacao.setAvaliador(buscarUsuario(dto.getAvaliadorId()));
        avaliacao.setBugueiro(buscarUsuario(dto.getBugueiroId()));
    }

    private Usuario buscarUsuario(Long id) {
        if (id == null) return null;
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário relacionado não encontrado"));
    }
}
