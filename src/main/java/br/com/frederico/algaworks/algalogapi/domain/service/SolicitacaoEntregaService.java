package br.com.frederico.algaworks.algalogapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.frederico.algaworks.algalogapi.domain.model.Cliente;
import br.com.frederico.algaworks.algalogapi.domain.model.Entrega;
import br.com.frederico.algaworks.algalogapi.domain.model.enuns.StatusEntrega;
import br.com.frederico.algaworks.algalogapi.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Transactional
	public Entrega solicitar (Entrega entrega) {

		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
	
}
