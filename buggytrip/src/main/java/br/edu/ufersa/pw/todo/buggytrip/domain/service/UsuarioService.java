package br.edu.ufersa.pw.todo.buggytrip.domain.service;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioDTO;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioPatch;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.UsuarioEntity;
import br.edu.ufersa.pw.todo.buggytrip.domain.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioEntity> listar() {
        return repository.findAll();
    }

    public UsuarioEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public UsuarioEntity salvar(UsuarioDTO dto) {
        return repository.save(toEntity(dto));
    }

    public UsuarioEntity atualizar(Long id, UsuarioDTO dto)
    {
        UsuarioEntity usuario = buscarPorId(id);
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setUsuarioTipo(dto.getTipo());
        return repository.save(usuario);
    }

    public UsuarioEntity alterarParcial(Long id, UsuarioPatch dto) {
        UsuarioEntity usuario = buscarPorId(id);
        if (dto.nome() != null) usuario.setNome(dto.nome());
        if (dto.email() != null) usuario.setEmail(dto.email());
        if (dto.senha() != null) usuario.setSenha(dto.senha());
        if (dto.tipo() != null) usuario.setUsuarioTipo(dto.tipo());
        return repository.save(usuario);
    }

    public void remover(Long id) {
        UsuarioEntity usuario = buscarPorId(id);
        repository.delete(usuario);
    }

    private UsuarioEntity toEntity(UsuarioDTO dto) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setUsuarioTipo(dto.getTipo());
        return usuario;
    }
}
