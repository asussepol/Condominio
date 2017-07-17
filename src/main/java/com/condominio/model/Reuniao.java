package com.condominio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reuniao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	@NotNull(message="data da reuniao é obrigatorio")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataReuniao;
	@NotEmpty(message="pauta é obrigatorio!")
	private String pauta;
	@NotEmpty(message="campo urgente é obrigatorio!!")
	private String urgente;
	@NotEmpty(message="campo local é obrigatorio!")
	private String local;
	private String observacao;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Date getDataReuniao() {
		return dataReuniao;
	}
	public void setDataReuniao(Date dataReuniao) {
		this.dataReuniao = dataReuniao;
	}
	public String getPauta() {
		return pauta;
	}
	public void setPauta(String pauta) {
		this.pauta = pauta;
	}
	public String getUrgente() {
		return urgente;
	}
	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String relatorio) {
		this.observacao = relatorio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reuniao other = (Reuniao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	

}
