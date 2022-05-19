package com.solebac.credRapido.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_atendentes")
public class Atendentes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Size(min=3, max = 30)
	private String nome;
	
	@NotNull
	@Size(min=11)
	@Column(unique = true)
	private String whatsapp;
	
	private String urlImg;
	
	@OneToMany(mappedBy = "atendentes")
	private List<Clientes> clients = new ArrayList<>();

	public Atendentes() {
		super();
	}

	public Atendentes(Integer id, @NotNull @Size(min = 3, max = 30) String nome, @NotNull @Size(min = 11) String whatsapp,
			String urlImg) {
		super();
		this.id = id;
		this.nome = nome;
		this.whatsapp = whatsapp;
		this.urlImg = urlImg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void addClientes(Clientes obj){
		clients.add(obj);
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	

}
