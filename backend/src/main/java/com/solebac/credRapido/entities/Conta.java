package com.solebac.credRapido.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.solebac.credRapido.entities.enums.MeioPgto;

@Entity
@Table(name = "tb_contas")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String agencia;
	@NotNull
	private String conta;
	@Enumerated(EnumType.STRING)
	private MeioPgto meio_pgto;
	
	@ManyToOne 
	@JoinColumn(name = "banco_id")
	private Banco banco;
	
	@OneToOne(mappedBy = "conta")
	private Beneficios beneficios;

	public Conta() {
	}

	public Conta(Long id, @NotNull String agencia, @NotNull String conta, MeioPgto meio_pgto, Banco banco) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.conta = conta;
		this.meio_pgto = meio_pgto;
		this.banco = banco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public MeioPgto getMeio_pgto() {
		return meio_pgto;
	}

	public void setMeio_pgto(MeioPgto meio_pgto) {
		this.meio_pgto = meio_pgto;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
}
