package br.edu.ufersa.pw.todo.buggytrip.domain.repositories;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
