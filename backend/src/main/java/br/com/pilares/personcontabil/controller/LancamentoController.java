package br.com.pilares.personcontabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pilares.personcontabil.model.dtos.LancamentoDTO;
import br.com.pilares.personcontabil.model.form.LancamentoForm;
import br.com.pilares.personcontabil.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<LancamentoDTO>  getById(@PathVariable Long id) {
		return lancamentoService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody LancamentoForm form) {
		return lancamentoService.create(form);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody LancamentoForm form, @PathVariable Long id) {
		return lancamentoService.edit(form, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return lancamentoService.deleteById(id);
	}
}
