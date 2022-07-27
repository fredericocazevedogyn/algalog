package br.com.frederico.algaworks.algalogapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frederico.algaworks.algalogapi.domain.model.Entrega;
import br.com.frederico.algaworks.algalogapi.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar (Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
		
	}
	
}
