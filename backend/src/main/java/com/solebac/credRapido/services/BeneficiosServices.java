package com.solebac.credRapido.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.solebac.credRapido.entities.Beneficios;
import com.solebac.credRapido.repositories.BeneficiosRepository;
import com.solebac.credRapido.services.exceptions.ResourceNotFoundException;

@Service
public class BeneficiosServices {
	@Autowired
	private BeneficiosRepository repository;

	public List<Beneficios> findAll() {
		return repository.findAll();
	}

	public Beneficios findById(Long id) {
		Optional<Beneficios> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Beneficios insert(Beneficios obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Beneficios update(Long id, Beneficios obj) {
		try {
			Beneficios ben = repository.getById(id);
			updateBeneficio(ben, obj);
			return repository.save(ben);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateBeneficio(Beneficios ben, Beneficios obj) {
		ben.setCliente(obj.getCliente());
		ben.setConta(obj.getConta());
		ben.setContrato(obj.getContrato());
		ben.setDateBeginBen(obj.getDateBeginBen());
		ben.setEspecie(obj.getEspecie());
		ben.setIfo(obj.getIfo());
		ben.setNumberBen(obj.getNumberBen());
	}

}
