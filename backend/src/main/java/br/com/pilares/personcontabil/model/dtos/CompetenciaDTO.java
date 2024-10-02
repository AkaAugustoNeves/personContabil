package br.com.pilares.personcontabil.model.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.com.pilares.personcontabil.model.entities.Competencia;
import br.com.pilares.personcontabil.model.entities.Lancamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaDTO {

	private Long id;
	private Integer mes;
	private Integer ano;
	private List<LancamentoResumidoDTO> lancamentos;
	private BigDecimal entradas;
	private BigDecimal saidas;
	private BigDecimal total;
	
	
	public CompetenciaDTO(Competencia entity) {
		this.id = entity.getId();
		this.mes = entity.getMes();
		this.ano = entity.getAno();
		this.lancamentos = LancamentoResumidoDTO.converter(entity.getLancamentos());
		this.entradas = entity.calcularEntradas();
		this.saidas = entity.calcularSaidas();
		this.total = entity.calcularTotal();
	}
	
}
