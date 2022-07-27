package br.com.frederico.algaworks.algalogapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frederico.algaworks.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.frederico.algaworks.algalogapi.domain.model.Entrega;
import br.com.frederico.algaworks.algalogapi.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	
}
