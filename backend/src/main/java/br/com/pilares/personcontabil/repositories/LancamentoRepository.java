package br.com.pilares.personcontabil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.personcontabil.model.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	List<Lancamento> findByCompetenciaId(Long id);
	
}
