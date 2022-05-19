package com.solebac.credRapido.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.solebac.credRapido.entities.Servicos;

public class ServicosDto {
	private Long id;
	private String titulo;
	private String descricao;
	public ServicosDto(Servicos servicos) {
		this.titulo = servicos.getTitulo();
		this.descricao = servicos.getDescricao();
		this.id = servicos.getId();
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public Long getId() {
		return id;
	}
	public static List<ServicosDto> ToCovert(List<Servicos> servicos) {
		return servicos.stream().map(ServicosDto::new).collect(Collectors.toList());
	}
	
	
}
