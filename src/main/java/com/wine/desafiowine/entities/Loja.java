package com.wine.desafiowine.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loja implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoLoja;
	private int faixaInicio;
	private int faixaFim;
	
	public Loja() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoLoja() {
		return codigoLoja;
	}
	public void setCodigoLoja(String codigoLoja) {
		this.codigoLoja = codigoLoja;
	}
	public int getFaixaInicio() {
		return faixaInicio;
	}
	public void setFaixaInicio(int faixaInicio) {
		this.faixaInicio = faixaInicio;
	}
	public int getFaixaFim() {
		return faixaFim;
	}
	public void setFaixaFim(int faixaFim) {
		this.faixaFim = faixaFim;
	}
	
	public Loja(Long id, String codigoLoja, int faixaInicio, int faixaFim) {
		super();
		this.id = id;
		this.codigoLoja = codigoLoja;
		this.faixaInicio = faixaInicio;
		this.faixaFim = faixaFim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cep [id=" + id + ", codigoLoja=" + codigoLoja + ", faixaInicio=" + faixaInicio + ", faixaFim="
				+ faixaFim + "]";
	}
	
	
	
	
	
	

}
