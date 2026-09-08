package br.edu.ufersa.pw.todo.buggytrip.domain.service;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioDTO;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.UsuarioEntity;
import br.edu.ufersa.pw.todo.buggytrip.domain.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

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

    public UsuarioEntity salvar(UsuarioDTO usuario) {
        return repository.save(usuario);
    }

}
