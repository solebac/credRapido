package com.solebac.credRapido.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.solebac.credRapido.controllers.dto.ServicosDto;
import com.solebac.credRapido.entities.Servicos;
import com.solebac.credRapido.services.ServicosServices;

@RestController
@RequestMapping(value = "/servicos")
public class ServicosController {
	
	@Autowired
	private ServicosServices services;
	
	@GetMapping
	public ResponseEntity<List<ServicosDto>> listAll() {
		
		return ResponseEntity.ok().body(ServicosDto.ToCovert(services.findAll()));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Servicos> findById(@PathVariable Long id){
		Servicos obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Servicos> cadastrar(@RequestBody Servicos servico){
		Servicos obj = services.insert(servico);
		/*return ResponseEntity.ok().body(obj); retornou 200ok*/
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Servicos> atualizar(@PathVariable Long id, @RequestBody Servicos obj){
		obj = services.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
