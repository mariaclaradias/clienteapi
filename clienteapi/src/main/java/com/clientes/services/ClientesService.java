package com.clientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.clientes.domain.Cliente;
import com.clientes.domain.Endereco;
import com.clientes.repository.ClientesRepository;
import com.clientes.repository.EnderecoRepository;
import com.services.exceptions.ClienteNotFoundException;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository clientesRepository;
	@Autowired
	private EnderecoRepository enderecosRepository;
	
	public List<Cliente> list(){
		return clientesRepository.findAll();
	}
	
	public Cliente buscar(Long id) {
		Cliente cliente = clientesRepository.findOne(id);
		if(cliente == null) {
			throw new ClienteNotFoundException("Cliente não encontrado.");
		}
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		cliente.setId(null);
		return clientesRepository.save(cliente);
	}
	
	public void deletar(long id) {
		try {
			clientesRepository.delete(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ClienteNotFoundException("AVISO: Cliente não encontrado.");
		}			
	}
	
	public void atualizar(Cliente cliente) {
		verificarExistencia(cliente);
		clientesRepository.save(cliente);
	}
	
	public void verificarExistencia(Cliente cliente) {
		buscar(cliente.getId());
	}
	
	public Endereco salvarEndereco(Long clienteId, Endereco endereco) {
		Cliente cliente = buscar(clienteId);
		endereco.setCliente(cliente);
		return enderecosRepository.save(endereco);
		
	}
	
	public List<Endereco> listarEnderecos(Long clienteId){
		Cliente cliente = buscar(clienteId);
		return cliente.getEnderecos();
	}
}