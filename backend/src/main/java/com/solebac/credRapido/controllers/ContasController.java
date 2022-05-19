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

import com.solebac.credRapido.entities.Conta;
import com.solebac.credRapido.services.ContasServices;

@RestController
@RequestMapping("/contas")
public class ContasController {
	@Autowired
	private ContasServices services;

	@GetMapping
	public ResponseEntity<List<Conta>> listAll() {
		List<Conta> lista = services.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id) {
		Conta obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Conta> insert(@RequestBody Conta obj) {
		Conta contas = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contas.getId()).toUri();
		return ResponseEntity.created(uri).body(contas);
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta obj) {
		Conta contas = services.update(id, obj);
		return ResponseEntity.ok().body(contas);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}