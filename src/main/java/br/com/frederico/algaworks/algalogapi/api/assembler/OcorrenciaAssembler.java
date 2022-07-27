package br.com.frederico.algaworks.algalogapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.frederico.algaworks.algalogapi.api.model.OcorrenciaModelDto;
import br.com.frederico.algaworks.algalogapi.domain.model.Ocorrencia;

@Component
public class OcorrenciaAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public OcorrenciaModelDto toModel (Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaModelDto.class);
	}
	
	public List<OcorrenciaModelDto> toCollectionModel (List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
	}
	
}
