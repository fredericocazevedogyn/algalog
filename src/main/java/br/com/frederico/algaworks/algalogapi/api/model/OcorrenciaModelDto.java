package br.com.frederico.algaworks.algalogapi.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaModelDto {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
}
