package br.edu.ufersa.pw.todo.buggytrip.domain.service;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request.UsuarioPutRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request.UsuarioPostRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioPutResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioPostResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioGetResponse;
import br.edu.ufersa.pw.todo.buggytrip.domain.mappers.UsuarioMapper;

import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Usuario;
import br.edu.ufersa.pw.todo.buggytrip.domain.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UsuarioGetResponse> listar() {
        return mapper.toResponseList(repository.findAll());
    }

    public UsuarioGetResponse buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        return mapper.toResponse(usuario);
    }

    public UsuarioPostResponse salvar(UsuarioPostRequest dto) {
        Usuario usuario = mapper.toEntity(dto);
        Usuario salvo = repository.save(usuario);
        return mapper.toPostResponse(salvo);
    }

    public UsuarioPutResponse atualizar(Long id, UsuarioPutRequest dto) {
        Usuario usuario = buscarEntityPorId(id);
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setUsuarioTipo(dto.tipo());
        Usuario atualizado = repository.save(usuario);
        return mapper.toPutResponse(atualizado);
    }

    public UsuarioPutResponse alterarParcial(Long id, UsuarioPutResponse dto) {
        Usuario usuario = buscarEntityPorId(id);
        if (dto.nome() != null) usuario.setNome(dto.nome());
        if (dto.email() != null) usuario.setEmail(dto.email());
        if (dto.tipo() != null) usuario.setUsuarioTipo(dto.tipo());
        Usuario atualizado = repository.save(usuario);
        return mapper.toPutResponse(atualizado);
    }

    public void remover(Long id) {
        Usuario usuario = buscarEntityPorId(id);
        repository.delete(usuario);
    }

    // Método auxiliar para obter a entidade sem mapear
    private Usuario buscarEntityPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }
}
