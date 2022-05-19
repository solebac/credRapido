package com.solebac.credRapido.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.solebac.credRapido.entities.Clientes;
import com.solebac.credRapido.entities.dependency.Endereco;
import com.solebac.credRapido.entities.dependency.Telefone;
import com.solebac.credRapido.repositories.ClientesRepository;
import com.solebac.credRapido.services.exceptions.DataBaseException;
import com.solebac.credRapido.services.exceptions.ResourceNotFoundException;

@Service
public class ClientesServices {
	
	@Autowired
	private ClientesRepository repository;
	
	public List<Clientes> findAll(){
		return repository.findAll();
	}
	public Clientes findById(Long id) {
		Optional<Clientes> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Clientes insert(Clientes obj) {
		return repository.save(obj);
	}
	public void deleter(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	public Clientes update(Long id, Clientes clientes) {
		try {
			Clientes obj = repository.getById(id);
			updateObj(obj, clientes);
			return repository.save(obj);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateObj(Clientes old, Clientes news) {
		old.setCpf(news.getCpf());
		old.setEmail(news.getEmail());
		old.setIdentidade(news.getIdentidade());
		old.setNome(news.getNome());
		old.setSexo(news.getSexo());
		old.setSalario(news.getSalario());
		old.setNascimento(news.getNascimento());
		Endereco address = new Endereco();
		address.setBairro(news.getEndereco().getBairro());
		address.setCep(news.getEndereco().getCep());
		address.setCidade(news.getEndereco().getCidade());
		address.setLogradouro(news.getEndereco().getLogradouro());
		address.setNumero(news.getEndereco().getNumero());
		address.setUf(news.getEndereco().getUf());
		old.setEndereco(address);
		Telefone fone = new Telefone();
		fone.setTelefone(news.getTelefone().getTelefone());
		fone.setTipoFone(news.getTelefone().getTipoFone());
		old.setTelefone(fone);
	}
}
