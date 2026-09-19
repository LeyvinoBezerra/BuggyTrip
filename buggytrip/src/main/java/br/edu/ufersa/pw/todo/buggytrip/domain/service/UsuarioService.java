package br.edu.ufersa.pw.todo.buggytrip.domain.service;

import br.edu.ufersa.pw.todo.buggytrip.features.usuario.UsuarioDTO;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioPatch;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Usuario;
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

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public Usuario salvar(UsuarioDTO dto) {
        return repository.save(toEntity(dto));
    }

    public Usuario atualizar(Long id, UsuarioDTO dto)
    {
        Usuario usuario = buscarPorId(id);
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setUsuarioTipo(dto.getTipo());
        return repository.save(usuario);
    }

    public Usuario alterarParcial(Long id, UsuarioPatch dto) {
        Usuario usuario = buscarPorId(id);
        if (dto.nome() != null) usuario.setNome(dto.nome());
        if (dto.email() != null) usuario.setEmail(dto.email());
        if (dto.senha() != null) usuario.setSenha(dto.senha());
        if (dto.tipo() != null) usuario.setUsuarioTipo(dto.tipo());
        return repository.save(usuario);
    }

    public void remover(Long id) {
        Usuario usuario = buscarPorId(id);
        repository.delete(usuario);
    }

    private Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setUsuarioTipo(dto.getTipo());
        return usuario;
    }
}
