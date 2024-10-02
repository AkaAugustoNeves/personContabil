package br.com.pilares.personcontabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.personcontabil.model.dtos.CompetenciaDTO;
import br.com.pilares.personcontabil.service.CompetenciaService;

@RestController
@RequestMapping("/competencia")
public class CompetenciaController {
	
	@Autowired
	private CompetenciaService competenciaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CompetenciaDTO> getById(@PathVariable Long id) {
		return competenciaService.findById(id);
	}

}
