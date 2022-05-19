package com.solebac.credRapido.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_beneficios")
public class Beneficios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigInteger contrato;
	private String numberBen;
	private Integer ifo;
	private Date dateBeginBen;
	private Integer especie;
	
	@OneToOne
	@JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta conta;
	
	@OneToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Clientes cliente;
	
	public Beneficios() {
		super();
	}
	
	public Beneficios(Long id, BigInteger contrato, String numberBen, Integer ifo, Date dateBeginBen, Integer especie) {
		super();
		this.id = id;
		this.contrato = contrato;
		this.numberBen = numberBen;
		this.ifo = ifo;
		this.dateBeginBen = dateBeginBen;
		this.especie = especie;
	}

	public Beneficios(Long id, BigInteger contrato, String numberBen, Integer ifo, Date dateBeginBen, Integer especie,
			Conta conta, Clientes cliente) {
		super();
		this.id = id;
		this.contrato = contrato;
		this.numberBen = numberBen;
		this.ifo = ifo;
		this.dateBeginBen = dateBeginBen;
		this.especie = especie;
		this.conta = conta;
		this.cliente = cliente;
	}

	/*Campo calculado da (+/-) Idade*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigInteger getContrato() {
		return contrato;
	}
	public void setContrato(BigInteger contrato) {
		this.contrato = contrato;
	}
	public String getNumberBen() {
		return numberBen;
	}
	public void setNumberBen(String numberBen) {
		this.numberBen = numberBen;
	}
	public Integer getIfo() {
		return ifo;
	}
	public void setIfo(Integer ifo) {
		this.ifo = ifo;
	}
	public Date getDateBeginBen() {
		return dateBeginBen;
	}
	public void setDateBeginBen(Date dateBeginBen) {
		this.dateBeginBen = dateBeginBen;
	}
	public Integer getEspecie() {
		return especie;
	}
	public void setEspecie(Integer especie) {
		this.especie = especie;
	}
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}	
	
}
