package com.solebac.credRapido.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.solebac.credRapido.entities.Atendentes;
import com.solebac.credRapido.repositories.AtendentesRepository;
import com.solebac.credRapido.services.exceptions.DataBaseException;
import com.solebac.credRapido.services.exceptions.ResourceNotFoundException;

@Service
public class AtendentesServices {
	@Autowired
	private AtendentesRepository repository;
	
	public List<Atendentes> findAll(){
		return repository.findAll();
	}
	
	public Atendentes findById(Integer id) {
		Optional<Atendentes> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Atendentes insert(Atendentes obj) {
		return repository.save(obj);
	}
	public void delete(int id) {
		try {
			repository.deleteById(id);	
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	public Atendentes update(Integer id, Atendentes obj) {
		try {
			Atendentes atendentes = repository.getById(id);
			atendentes.setNome(obj.getNome());
			repository.save(atendentes);
			return atendentes;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
}
