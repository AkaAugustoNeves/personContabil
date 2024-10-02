package br.com.pilares.personcontabil.model.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pilares.personcontabil.model.entities.Lancamento;
import br.com.pilares.personcontabil.model.enuns.TipoLancamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoResumidoDTO {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private TipoLancamento tipoLancamento;
	
	public LancamentoResumidoDTO(Lancamento entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.valor = entity.getValor();
		this.tipoLancamento = entity.getTipoLancamento();
	}
	
	public static List<LancamentoResumidoDTO> converter (List<Lancamento> entities){
		return entities.stream().map(LancamentoResumidoDTO::new).collect(Collectors.toList());
	}
	
}
