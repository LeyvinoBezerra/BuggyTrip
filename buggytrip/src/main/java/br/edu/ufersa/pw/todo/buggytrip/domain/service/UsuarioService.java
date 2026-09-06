package br.edu.ufersa.pw.todo.buggytrip.domain.service;
import com.buggytrip.model.Usuario;
import com.buggytrip.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

}
