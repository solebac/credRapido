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

import com.solebac.credRapido.controllers.dto.ClientesDto;
import com.solebac.credRapido.entities.Clientes;
import com.solebac.credRapido.services.ClientesServices;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesServices services;
	
	@GetMapping
	public ResponseEntity<List<ClientesDto>> findAll(){
		List<ClientesDto> list = ClientesDto.toClientes(services.findAll());
		return ResponseEntity.ok().body(list);
	}
	/*
	 * Retorno Entities Origin
	 * 	@GetMapping
	public ResponseEntity<List<Clientes>> listAll(){
		List<Clientes> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	 * */
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientesDto> findById(@PathVariable Long id) {
		ClientesDto obj = ClientesDto.toClientesId(services.findById(id)) ;
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Clientes> cadastrar(@RequestBody Clientes clientes) {
		Clientes obj = services.insert(clientes);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.deleter(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Clientes> update(@PathVariable Long id, @RequestBody Clientes clientes) {
		Clientes obj = services.update(id, clientes);
		return ResponseEntity.ok().body(obj);
	}
}
