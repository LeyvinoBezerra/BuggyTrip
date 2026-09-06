package br.edu.ufersa.pw.todo.buggytrip.domain.repositories;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
