package br.com.pilares.personcontabil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pilares.personcontabil.model.entities.Competencia;

public interface CompetenciaRepository extends JpaRepository<Competencia, Long>{

	@Query("SELECT DISTINCT c.ano FROM Competencia c ORDER BY c.ano ASC")
    List<Integer> findDistinctAnos();
	
}
