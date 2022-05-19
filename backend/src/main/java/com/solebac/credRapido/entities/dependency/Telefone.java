package com.solebac.credRapido.entities.dependency;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.solebac.credRapido.entities.enums.TipoFone;

@Embeddable
public class Telefone {
	
	@Enumerated(EnumType.STRING)
	private TipoFone tipoFone;
	@NotNull
	@Size(min=11, max=15)
	private String telefone;
	public Telefone() {}
	public Telefone(TipoFone tipoFone, String telefone) {
		super();
		this.tipoFone = tipoFone;
		this.telefone = telefone;
	}
	public TipoFone getTipoFone() {
		return tipoFone;
	}
	public void setTipoFone(TipoFone tipoFone) {
		this.tipoFone = tipoFone;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
