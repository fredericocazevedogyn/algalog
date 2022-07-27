package br.com.frederico.algaworks.algalogapi.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInputDto {

	@Valid
	@NotNull
	private ClienteIdInput cliente;
	
	@Valid
	@NotNull
	private DestinatarioInput destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
		
}
