package com.solebac.credRapido.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.solebac.credRapido.entities.Conta;
import com.solebac.credRapido.repositories.ContasRepository;
import com.solebac.credRapido.services.exceptions.ResourceNotFoundException;

@Service
public class ContasServices {
	@Autowired
	private ContasRepository repository;

	public List<Conta> findAll() {
		return repository.findAll();
	}

	public Conta findById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Conta insert(Conta obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ResourceNotFoundException(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Conta update(Long id, Conta obj) {
		try {
			Conta contas = repository.getById(id);
			updateContas(contas, obj);
			return repository.save(contas);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateContas(Conta contas, Conta obj) {
		contas.setAgencia(obj.getAgencia());
		contas.setConta(obj.getConta());
		contas.setMeio_pgto(obj.getMeio_pgto());
		contas.setBanco(obj.getBanco());
	}
}
