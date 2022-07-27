package br.com.frederico.algaworks.algalogapi.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.frederico.algaworks.algalogapi.domain.exception.NegocioException;
import br.com.frederico.algaworks.algalogapi.domain.model.Cliente;
import br.com.frederico.algaworks.algalogapi.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		validaEmail(cliente);	
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	public void validaEmail(Cliente cliente) {
		
		Optional<Cliente> obj = clienteRepository.findByEmail(cliente.getEmail());
		
		if (obj.isPresent() && obj.get().getId() != cliente.getId()) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail!");
		}
		
	}
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId).orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
	}
	
}
