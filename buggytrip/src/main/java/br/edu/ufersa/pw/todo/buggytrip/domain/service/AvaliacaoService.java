package br.edu.ufersa.pw.todo.buggytrip.domain.service;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Avaliacao.request.AvaliacaoPostRequest;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Avaliacao;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Usuario;
import br.edu.ufersa.pw.todo.buggytrip.domain.mappers.AvaliacaoMapper;
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
    private final AvaliacaoMapper mapper;

    public AvaliacaoService(
            AvaliacaoRepository repository,
            UsuarioRepository usuarioRepository,
            AvaliacaoMapper mapper) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public List<Avaliacao> listar() {
        return repository.findAll();
    }

    public Avaliacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Avaliação não encontrada"));
    }

    public Avaliacao salvar(AvaliacaoPostRequest dto) {
        Avaliacao avaliacao = mapper.toAvaliacao(dto);
        avaliacao.setAvaliador(buscarUsuario(dto.avaliadorId()));
        avaliacao.setBugueiro(buscarUsuario(dto.bugueiroId()));
        return repository.save(avaliacao);
    }

    public Avaliacao atualizar(Long id, AvaliacaoPostRequest dto) {
        Avaliacao avaliacao = buscarPorId(id);
        copy(mapper.toAvaliacao(dto), avaliacao);
        avaliacao.setAvaliador(buscarUsuario(dto.avaliadorId()));
        avaliacao.setBugueiro(buscarUsuario(dto.bugueiroId()));
        return repository.save(avaliacao);
    }

    public Avaliacao atualizarParcial(Long id, AvaliacaoPostRequest dto) {
        Avaliacao avaliacao = buscarPorId(id);
        copy(mapper.toAvaliacao(dto), avaliacao);
        avaliacao.setAvaliador(buscarUsuario(dto.avaliadorId()));
        avaliacao.setBugueiro(buscarUsuario(dto.bugueiroId()));
        return repository.save(avaliacao);
    }

    public void remover(Long id) {
        Avaliacao avaliacao = buscarPorId(id);
        repository.delete(avaliacao);
    }

    private void copy(Avaliacao origem, Avaliacao destino) {
        destino.setSeguranca(origem.getSeguranca());
        destino.setConhecimentoRoteiro(origem.getConhecimentoRoteiro());
        destino.setConfortoVeiculo(origem.getConfortoVeiculo());
        destino.setSimpatiaMotorista(origem.getSimpatiaMotorista());
        destino.setExperienciaGeral(origem.getExperienciaGeral());
        destino.setAdaptabilidade(origem.getAdaptabilidade());
        destino.setParadasInteressantes(origem.getParadasInteressantes());
        destino.setDiferencial(origem.getDiferencial());
        destino.setFeedback(origem.getFeedback());
    }

    private Usuario buscarUsuario(Long id) {
        if (id == null) {
            return null;
        }
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário relacionado não encontrado"));
    }
}
