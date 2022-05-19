package com.solebac.credRapido.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.solebac.credRapido.entities.Servicos;
import com.solebac.credRapido.repositories.ServicosRepository;
import com.solebac.credRapido.services.exceptions.DataBaseException;
import com.solebac.credRapido.services.exceptions.ResourceNotFoundException;

@Service
public class ServicosServices {

	@Autowired
	private ServicosRepository repository;

	public List<Servicos> findAll() {
		return repository.findAll();
	}

	public Servicos findById(Long id) {
		Optional<Servicos> obj = repository.findById(id);
		//return obj.get(); trocar por orElseThrow tenta dar o get senao throw exception
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Servicos insert(Servicos obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {//EmptyResultDataAccessException
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Servicos update(Long id, Servicos obj) {
		try {
			Servicos entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);	
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Servicos entity, Servicos obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setTitulo(obj.getTitulo());

	}
}
