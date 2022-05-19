package com.solebac.credRapido.controllers.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.solebac.credRapido.entities.Beneficios;

public class BeneficiosDto {

	private String id;
	private String contrato;
	private String numberBen;
	private String ifo;
	private Date dateBeginBen;
	private Integer especie;
	// Contas
	private String acountsAgencia;
	private String acountsConta;
	private String acountsMeioPgto;
	private String acountsDescricaoBanco;
	// Cliente
	private String clientsNome;
	private String clientsCpf;
	private String clientsIdentidade;
	private String clientsEmail;
	private String clientsSexo;
	private String clientsEstadoCivil;
	private Date clientsNascimento;

	public BeneficiosDto(Beneficios obj) {
		this.id = String.valueOf(obj.getId());
		this.contrato = String.valueOf(obj.getContrato());
		this.numberBen = obj.getNumberBen();
		this.ifo = String.valueOf(obj.getIfo());
		this.dateBeginBen = obj.getDateBeginBen();
		this.especie = obj.getEspecie();
		this.acountsAgencia = obj.getConta().getAgencia();
		this.acountsConta = obj.getConta().getConta();
		this.acountsMeioPgto = String.valueOf(obj.getConta().getMeio_pgto());
		this.acountsDescricaoBanco = obj.getConta().getBanco().getDescricao();
		this.clientsNome = obj.getCliente().getNome();
		this.clientsCpf = obj.getCliente().getCpf();
		this.clientsIdentidade = obj.getCliente().getIdentidade();
		this.clientsEmail = obj.getCliente().getEmail();
		this.clientsSexo = String.valueOf(obj.getCliente().getSexo());
		this.clientsEstadoCivil = String.valueOf(obj.getCliente().getEstadoCivil());
		this.clientsNascimento = obj.getCliente().getNascimento();
	}

	public String getId() {
		return id;
	}

	public String getContrato() {
		return contrato;
	}

	public String getNumberBen() {
		return numberBen;
	}

	public String getIfo() {
		return ifo;
	}

	public Date getDateBeginBen() {
		return dateBeginBen;
	}

	public Integer getEspecie() {
		return especie;
	}

	public String getAcountsAgencia() {
		return acountsAgencia;
	}

	public String getAcountsConta() {
		return acountsConta;
	}

	public String getAcountsMeioPgto() {
		return acountsMeioPgto;
	}

	public String getAcountsDescricaoBanco() {
		return acountsDescricaoBanco;
	}

	public String getClientsNome() {
		return clientsNome;
	}

	public String getClientsCpf() {
		return clientsCpf;
	}

	public String getClientsIdentidade() {
		return clientsIdentidade;
	}

	public String getClientsEmail() {
		return clientsEmail;
	}

	public String getClientsSexo() {
		return clientsSexo;
	}

	public String getClientsEstadoCivil() {
		return clientsEstadoCivil;
	}

	public Date getClientsNascimento() {
		return clientsNascimento;
	}

	public static List<BeneficiosDto> toConvert(List<Beneficios> lista) {
		return lista.stream().map(BeneficiosDto::new).collect(Collectors.toList());
	}
	public static BeneficiosDto toConvert(Beneficios obj) {
		return new BeneficiosDto(obj);
	}

}
