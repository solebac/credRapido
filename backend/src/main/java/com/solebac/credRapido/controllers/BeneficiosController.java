package com.solebac.credRapido.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.solebac.credRapido.controllers.dto.BeneficiosDto;
import com.solebac.credRapido.entities.Beneficios;
import com.solebac.credRapido.services.BeneficiosServices;

@RestController
@RequestMapping(value = "/beneficios")
public class BeneficiosController {
	
	@Autowired
	private BeneficiosServices services;
	
	@GetMapping
	public ResponseEntity<List<BeneficiosDto>> listAll() {
		List<BeneficiosDto> obj = BeneficiosDto.toConvert(services.findAll());
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BeneficiosDto> findById(@PathVariable Long id, 
			@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		BeneficiosDto obj = BeneficiosDto.toConvert(services.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Beneficios> insert(@RequestBody Beneficios obj) {
		Beneficios bens = services.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bens.getId()).toUri();
		return ResponseEntity.created(uri).body(bens);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Beneficios> update(@PathVariable Long id, @RequestBody Beneficios obj) {
		services.update(id, obj);
		return ResponseEntity.ok().body(null);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
