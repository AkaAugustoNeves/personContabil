package br.com.pilares.personcontabil.model.enuns;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum TipoLancamento {

	ENTRADA(1L, "ENTRADA"),
	SAIDA(2L, "SAIDA");
	
	private TipoLancamento(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	private Long id;
	private String descricao;	
	
}
