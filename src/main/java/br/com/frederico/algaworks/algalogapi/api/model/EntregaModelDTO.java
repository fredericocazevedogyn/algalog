package br.com.frederico.algaworks.algalogapi.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.frederico.algaworks.algalogapi.domain.model.enuns.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModelDTO {

	private Long id;
	private String nomeCliente;
	private DestinatarioModelDTO destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
}
