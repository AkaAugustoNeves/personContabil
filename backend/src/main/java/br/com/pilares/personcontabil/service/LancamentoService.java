package br.com.pilares.personcontabil.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pilares.personcontabil.model.dtos.LancamentoDTO;
import br.com.pilares.personcontabil.model.entities.Competencia;
import br.com.pilares.personcontabil.model.entities.Lancamento;
import br.com.pilares.personcontabil.model.form.LancamentoForm;
import br.com.pilares.personcontabil.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private CompetenciaService competenciaService;
	
	public ResponseEntity<LancamentoDTO> findById(Long id){
		Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
		if(lancamento.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new LancamentoDTO(lancamento.get()));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	public ResponseEntity<?> deleteById(Long id){
		Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
		if(lancamento.isPresent()) {
			lancamentoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	public ResponseEntity<?> create(LancamentoForm form) {
		Optional<Competencia> competencia = competenciaService.buscarPorId(form.getCompetencia().getId());
		if(competencia.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new LancamentoDTO(lancamentoRepository.save(new Lancamento(competencia.get(), form))));
		}		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competência não encontrada");
	}

	public ResponseEntity<?> edit(LancamentoForm form, Long id) {
		Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
		if(lancamento.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new LancamentoDTO(lancamentoRepository.save(new Lancamento(lancamento.get(), form))));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
