package com.solebac.credRapido.entities.dependency;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.solebac.credRapido.entities.enums.TipoLogradouro;
import com.solebac.credRapido.entities.enums.Uf;

@Embeddable
public class Endereco {

	@NotNull
	@Size(max=85)
	private String cidade;
	@NotNull
	private String logradouro;
	@NotNull
	private String bairro;
	private String cep;
	@NotNull
	private String numero;
	@NotNull
	@Size(max=2)
	private Uf uf;
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tpLogradouro;
	
	public Endereco() {}
	public Endereco(String cidade, String logradouro, String bairro, String cep, String numero, Uf uf,
			TipoLogradouro tpLogradouro) {
		super();
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.uf = uf;
		this.tpLogradouro = tpLogradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public TipoLogradouro getTpLogradouro() {
		return tpLogradouro;
	}
	public void setTpLogradouro(TipoLogradouro tpLogradouro) {
		this.tpLogradouro = tpLogradouro;
	}
	
	
	
}
