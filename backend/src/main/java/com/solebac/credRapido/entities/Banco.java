package com.solebac.credRapido.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_banco")
public class Banco {

	private static final long serialVersionUID = 1L;

	
	@Id
	@NotNull
	private Long id;
	@NotNull
	private String descricao;
	@OneToMany(mappedBy = "banco")
	private List<Conta> contas = new ArrayList<>();
	
	public Banco() {
		super();
	}
	public Banco(@NotNull long id, @NotNull String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
