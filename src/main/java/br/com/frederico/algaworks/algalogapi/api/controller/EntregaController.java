package br.com.frederico.algaworks.algalogapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.frederico.algaworks.algalogapi.api.assembler.EntregaAssembler;
import br.com.frederico.algaworks.algalogapi.api.model.EntregaModelDTO;
import br.com.frederico.algaworks.algalogapi.api.model.input.EntregaInputDto;
import br.com.frederico.algaworks.algalogapi.domain.repository.EntregaRepository;
import br.com.frederico.algaworks.algalogapi.domain.service.FinalizacaoEntregaService;
import br.com.frederico.algaworks.algalogapi.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private EntregaAssembler entregaAssembler;
	
	@Autowired
	private FinalizacaoEntregaService finalizacaoEntregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModelDTO criar (@Valid @RequestBody EntregaInputDto entrega) {
		return entregaAssembler.toModel(solicitacaoEntregaService.solicitar(entregaAssembler.toEntity(entrega)));
	}
	
	@GetMapping
	public List<EntregaModelDTO> listar () {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModelDTO> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
	
}
