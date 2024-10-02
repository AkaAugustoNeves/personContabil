package br.com.pilares.personcontabil.model.entities;

import java.math.BigDecimal;

import br.com.pilares.personcontabil.model.enuns.TipoLancamento;
import br.com.pilares.personcontabil.model.form.LancamentoForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_LANCAMENTO", nullable = false)
	private TipoLancamento tipoLancamento;
	@ManyToOne
	private Competencia competencia;
	
	public Lancamento(Competencia competencia, String descricao, BigDecimal valor, TipoLancamento tipoLancamento) {
		this.competencia = competencia;
		this.descricao = descricao;
		this.valor = valor;
		this.tipoLancamento = tipoLancamento;
	}
	
	public Lancamento(Competencia competencia, LancamentoForm form) {
		this.competencia = competencia;
		this.descricao = form.getDescricao();
		this.valor = form.getValor();
		this.tipoLancamento = form.getTipoLancamento();
	}
	
	public Lancamento(Lancamento entity, LancamentoForm form) {
		this.id = entity.getId();
		this.descricao = form.getDescricao();
		this.valor = form.getValor();
		this.tipoLancamento = form.getTipoLancamento();
		this.competencia = entity.getCompetencia();
	}
	
}
