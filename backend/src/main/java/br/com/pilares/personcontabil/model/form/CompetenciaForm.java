package br.com.pilares.personcontabil.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaForm {

	private Integer mes;
	private Integer ano;
	
	public Long getId(){
		return Long.parseLong(""+this.mes+this.ano);
	}
	
}
