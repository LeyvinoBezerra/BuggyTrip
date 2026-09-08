package br.edu.ufersa.pw.todo.buggytrip.domain.repositories;


import br.edu.ufersa.pw.todo.buggytrip.domain.entities.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
}