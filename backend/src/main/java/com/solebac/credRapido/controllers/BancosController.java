package com.solebac.credRapido.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.solebac.credRapido.entities.Banco;
import com.solebac.credRapido.services.BancosServices;

@RestController
@RequestMapping("/bancos")
public class BancosController {
	@Autowired
	private BancosServices services;
	
	@GetMapping
	public ResponseEntity<List<Banco>> listAll() {
		List<Banco> lista = services.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Banco> findById(@PathVariable Long id) {
		Banco obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Banco> insert(@RequestBody Banco obj) {
		Banco bancos = services.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(bancos);
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Banco> update(@PathVariable Long id, @RequestBody Banco obj) {
		Banco bancos = services.update(id, obj);
		return ResponseEntity.ok().body(bancos);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
