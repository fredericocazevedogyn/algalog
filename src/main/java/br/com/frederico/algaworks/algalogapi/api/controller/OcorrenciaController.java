package br.com.frederico.algaworks.algalogapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.frederico.algaworks.algalogapi.api.assembler.OcorrenciaAssembler;
import br.com.frederico.algaworks.algalogapi.api.model.OcorrenciaModelDto;
import br.com.frederico.algaworks.algalogapi.api.model.input.OcorrenciaInputDto;
import br.com.frederico.algaworks.algalogapi.domain.model.Entrega;
import br.com.frederico.algaworks.algalogapi.domain.model.Ocorrencia;
import br.com.frederico.algaworks.algalogapi.domain.service.BuscaEntregaService;
import br.com.frederico.algaworks.algalogapi.domain.service.RegistroOcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;
	
	@Autowired
	private OcorrenciaAssembler ocorrenciaAssebler;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModelDto registrar (@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInputDto ocorrenciaInput) {
		Ocorrencia ocorrencia = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssebler.toModel(ocorrencia);
	}
	
	@GetMapping
	public List<OcorrenciaModelDto> listar (@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaAssebler.toCollectionModel(entrega.getOcorrencias());
	}
}
