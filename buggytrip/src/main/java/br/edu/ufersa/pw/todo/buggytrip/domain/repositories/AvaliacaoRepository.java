package br.edu.ufersa.pw.todo.buggytrip.domain.repositories;


import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}