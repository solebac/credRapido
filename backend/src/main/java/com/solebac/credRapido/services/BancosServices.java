package com.solebac.credRapido.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.solebac.credRapido.controllers.exceptions.ResourceExceptionHandler;
import com.solebac.credRapido.entities.Banco;
import com.solebac.credRapido.repositories.BancosRepository;
import com.solebac.credRapido.services.exceptions.DataBaseException;
import com.solebac.credRapido.services.exceptions.ResourceNotFoundException;

@Service
public class BancosServices {
	@Autowired
	private BancosRepository repository;

	public List<Banco> findAll() {
		return repository.findAll();
	}

	public Banco findById(long id) {
		Optional<Banco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Banco insert(Banco bancos) {
		return repository.save(bancos);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Banco update(Long id, Banco bancos) {
		try {
			Banco obj = repository.getById(id);
			obj.setDescricao(bancos.getDescricao());
			return repository.save(obj);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
