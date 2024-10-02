package br.com.pilares.personcontabil.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pilares.personcontabil.model.dtos.CompetenciaDTO;
import br.com.pilares.personcontabil.model.entities.Competencia;
import br.com.pilares.personcontabil.repositories.CompetenciaRepository;

@Service
public class CompetenciaService {

	@Autowired
	private CompetenciaRepository competenciaRepository;
	
	public Optional<Competencia> buscarPorId(Long id){
		return competenciaRepository.findById(id);
	}

	public ResponseEntity<CompetenciaDTO> findById(Long id) {
		Optional<Competencia> competencia = competenciaRepository.findById(id);
		if(competencia.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new CompetenciaDTO(competencia.get()));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
