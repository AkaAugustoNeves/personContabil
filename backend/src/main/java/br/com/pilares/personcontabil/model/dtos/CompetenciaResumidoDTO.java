package br.com.pilares.personcontabil.model.dtos;

import br.com.pilares.personcontabil.model.entities.Competencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaResumidoDTO {

	private Long id;
	private Integer mes;
	private Integer ano;
	
	public CompetenciaResumidoDTO(Competencia entity) {
		this.id = entity.getId();
		this.mes = entity.getMes();
		this.ano = entity.getAno();
	}
	
}
