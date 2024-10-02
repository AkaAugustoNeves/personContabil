package br.com.pilares.personcontabil.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.pilares.personcontabil.model.entities.Competencia;
import br.com.pilares.personcontabil.repositories.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class SeedDataConfig implements CommandLineRunner {
	
	@Autowired
	private CompetenciaRepository competenciaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		this.sendDataCompetencia();
	}

	private void sendDataCompetencia(){
		if(competenciaRepository.count() == 0) {
			for (int i = 2024; i <= 2026; i++) {
				for (int j = 1; j <= 12; j++) {
					competenciaRepository.save(new Competencia(j, i));
				}
			}
			
		}
	}
	
}
