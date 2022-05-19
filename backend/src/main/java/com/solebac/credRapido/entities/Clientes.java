package com.solebac.credRapido.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Embedded;
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
import javax.validation.constraints.Size;

import com.solebac.credRapido.entities.dependency.Endereco;
import com.solebac.credRapido.entities.dependency.Telefone;
import com.solebac.credRapido.entities.enums.EstadoCivil;
import com.solebac.credRapido.entities.enums.Sexo;

@Entity
@Table(name = "tb_clientes")
public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max = 50, min = 10)
	private String nome;
	@NotNull
	@Size(min = 13)
	private String cpf;
	@Size(max = 50, min = 5)
	private String identidade;
	@Size(max = 85)
	private String email;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	private Date inclusao;
	@NotNull
	private Date nascimento;
	@NotNull
	private Double salario;
	@NotNull
	private Boolean ativo;
	@Embedded
	private Endereco endereco;
	@Embedded
	private Telefone telefone;

	@ManyToOne
	@JoinColumn(name = "atendentes_id")
	private Atendentes atendentes;

	@OneToOne(mappedBy = "cliente")
	private Beneficios beneficios;

	public Clientes() {
	}

	public Clientes(Long id, String nome, String cpf, String identidade, String email, Sexo sexo,
			EstadoCivil estadoCivil, Date inclusao, Boolean ativo, Double salario, Date nascimento, Endereco endereco,
			Telefone telefone, Atendentes atendentes) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.identidade = identidade;
		this.email = email;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.inclusao = inclusao;
		this.ativo = ativo;
		this.endereco = endereco;
		this.telefone = telefone;
		this.salario = salario;
		this.nascimento = nascimento;
		this.atendentes = atendentes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getInclusao() {
		return inclusao;
	}

	public void setInclusao(Date inclusao) {
		this.inclusao = inclusao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Atendentes getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(Atendentes atendentes) {
		this.atendentes = atendentes;
	}
	
	public int getBirthday(Date birthday) {
		if (birthday == null) {
			return 0;
		}
		Date hoje = new Date();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(birthday);
		cal2.setTime(hoje);
		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		int month1 = cal1.get(Calendar.MONTH);
		int month2 = cal2.get(Calendar.MONTH);
		
		if (month1 > month2) {
			return year2 - (year1 + 1);
		}
		
		return year2 - year1;

	}

}
