package br.com.pilares.personcontabil.model.dtos;

import java.math.BigDecimal;

import br.com.pilares.personcontabil.model.entities.Lancamento;
import br.com.pilares.personcontabil.model.enuns.TipoLancamento;
import br.com.pilares.personcontabil.model.form.LancamentoForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoDTO {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private TipoLancamento tipoLancamento;
	private CompetenciaResumidoDTO competencia;
	
	public LancamentoDTO(Lancamento entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.valor = entity.getValor();
		this.tipoLancamento = entity.getTipoLancamento();
		this.competencia = entity.getCompetencia() != null ? new CompetenciaResumidoDTO(entity.getCompetencia()) : null;	
	}

	public LancamentoDTO(Lancamento entity, LancamentoForm form) {
		this.id = entity.getId();
		this.descricao = form.getDescricao();
		this.valor = form.getValor();
		this.tipoLancamento = form.getTipoLancamento();
	}
	
}
