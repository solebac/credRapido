package com.solebac.credRapido.controllers.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.solebac.credRapido.entities.Clientes;
import com.solebac.credRapido.entities.enums.EstadoCivil;
import com.solebac.credRapido.entities.enums.Sexo;
import com.solebac.credRapido.entities.enums.TipoFone;
import com.solebac.credRapido.entities.enums.TipoLogradouro;
import com.solebac.credRapido.entities.enums.Uf;

public class ClientesDto {
	private Long id;
	private String nome;
	private String cpf;
	private String identidade;
	private String email;
	private Sexo sexo;
	private EstadoCivil estadoCivil;
	private Date inclusao;
	private Double salario;
	private Date nascimento;
	private Integer idade;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String cidade;
	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String uf;
	private String tpLogradouro;
	
	private String tipoFone;
	private String telefone;

	
	public ClientesDto(Clientes obj) {
		super();
		//Cliente
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.identidade = obj.getIdentidade();
		this.email = obj.getEmail();
		this.sexo = obj.getSexo();
		this.estadoCivil = obj.getEstadoCivil();
		this.inclusao = obj.getInclusao();
		this.salario = obj.getSalario();
		this.nascimento = obj.getNascimento();
		this.idade = obj.getBirthday(this.nascimento);
		//Endereco
		this.cidade = obj.getEndereco().getCidade();
		this.logradouro = obj.getEndereco().getLogradouro();
		this.bairro = obj.getEndereco().getBairro();
		this.cep = obj.getEndereco().getCep();
		this.numero = obj.getEndereco().getNumero();
		this.uf = String.valueOf(obj.getEndereco().getUf());
		this.tpLogradouro = String.valueOf(obj.getEndereco().getTpLogradouro());
		//Telefone
		this.tipoFone = String.valueOf(obj.getTelefone().getTipoFone());
		this.telefone = obj.getTelefone().getTelefone();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public String getEmail() {
		return email;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public String getInclusao(){
		/*Date di = sdf.parse("26/04/2022");
		return di;*/
		return sdf.format(inclusao);
	}

	public String getCidade() {
		return cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}

	public String getUf() {
		return uf;
	}

	public String getTpLogradouro() {
		return tpLogradouro;
	}
	
	public String getTipoFone() {
		return tipoFone;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public Double getSalario() {
		return salario;
	}

	public Date getNascimento() {
		return nascimento;
	}
	
	public Integer getIdade() {
		return idade;
	}

	public static List<ClientesDto> toClientes(List<Clientes> clientes) {
		return clientes.stream().map(ClientesDto::new).collect(Collectors.toList());
	}

	public static ClientesDto toClientesId(Clientes clientes) {
		// TODO Auto-generated method stub
		return new ClientesDto(clientes);
	}	
}
