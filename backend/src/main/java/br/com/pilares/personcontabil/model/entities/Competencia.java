package br.com.pilares.personcontabil.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.pilares.personcontabil.model.enuns.TipoLancamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Competencia {

	@Id
	@Column(name = "ID", nullable = false)
	private Long id;
	@Column(name = "MES", nullable = false)
	private Integer mes;
	@Column(name = "ANO", nullable = false)
	private Integer ano;
	@OneToMany(mappedBy = "competencia")
	private List<Lancamento> lancamentos = new ArrayList<>();
	
	public Competencia(Integer mes, Integer ano) {
		this.mes = mes;
		this.ano = ano;
		this.id =  Long.parseLong(""+ mes + ano); 
	}
	
	private BigDecimal calcular(TipoLancamento tipoLancamento) {
		return this.lancamentos.stream()
		.filter(lancamento -> lancamento.getTipoLancamento() == tipoLancamento)
		.map(Lancamento::getValor)
		.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public BigDecimal calcularEntradas() {
		return calcular(TipoLancamento.ENTRADA);
	}
	
	public BigDecimal calcularSaidas() {
		return calcular(TipoLancamento.SAIDA);
	}
	
	public BigDecimal calcularTotal() {
		BigDecimal totalSaida = calcularSaidas();
		BigDecimal totalEntrada = calcularEntradas();
		return totalEntrada.subtract(totalSaida);
	}
	
}
