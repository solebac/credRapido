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

import com.solebac.credRapido.entities.Atendentes;
import com.solebac.credRapido.services.AtendentesServices;

@RestController
@RequestMapping("/atendentes")
public class AtendentesController {
	
	@Autowired
	private AtendentesServices services;
	
	@GetMapping
	public ResponseEntity<List<Atendentes>> listAll(){
		List<Atendentes> lista = services.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Atendentes> pesquisa(@PathVariable int id){
		Atendentes obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Atendentes> atualizar(@PathVariable int id, @RequestBody Atendentes atendentes){
		Atendentes obj = services.update(id, atendentes);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable Integer id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Atendentes> insert(@RequestBody Atendentes obj){
		Atendentes atendentes = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(atendentes.getId()).toUri();
		return ResponseEntity.created(uri).body(atendentes);
	}
}
