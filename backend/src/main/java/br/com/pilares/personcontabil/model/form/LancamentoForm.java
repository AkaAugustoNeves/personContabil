package br.com.pilares.personcontabil.model.form;

import java.math.BigDecimal;

import br.com.pilares.personcontabil.model.enuns.TipoLancamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoForm {
	
	private String descricao;
	private BigDecimal valor;
	private TipoLancamento tipoLancamento;
	private CompetenciaForm competencia;

}
