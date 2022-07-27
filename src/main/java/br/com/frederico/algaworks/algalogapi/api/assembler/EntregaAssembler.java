package br.com.frederico.algaworks.algalogapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.frederico.algaworks.algalogapi.api.model.EntregaModelDTO;
import br.com.frederico.algaworks.algalogapi.api.model.input.EntregaInputDto;
import br.com.frederico.algaworks.algalogapi.domain.model.Entrega;

@Component
public class EntregaAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public EntregaModelDTO toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModelDTO.class);
	}
	
	public List<EntregaModelDTO> toCollectionModel (List<Entrega> entregas) {
		return entregas.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInputDto entregaInputDto) {
		return modelMapper.map(entregaInputDto, Entrega.class);
	}
}
