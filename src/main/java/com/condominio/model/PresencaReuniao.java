package com.condominio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;

@Entity
public class PresencaReuniao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	@NotEmpty(message="Campo nome do participante é  obrigatorio!")
	private String nomeParticipante;
	@NotEmpty(message="Campo Procuração é  obrigatorio!")
	private String procuracao;
	@NotEmpty(message="Campo observação éo obrigatorio!")
	private String observacao;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeParticipante() {
		return nomeParticipante;
	}
	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}
	public String getProcuracao() {
		return procuracao;
	}
	public void setProcuracao(String procuracao) {
		this.procuracao = procuracao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@ManyToOne
	@JoinColumn(name="idReuniao")
	private Reuniao reuniao;
	
	
	
	
	public Reuniao getReuniao() {
		return reuniao;
	}
	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}
	
	@ManyToOne
	@JoinColumn(name="idUnidade")
	private Unidades unidades;
	
	
	public Unidades getUnidades() {
		return unidades;
	}
	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeParticipante == null) ? 0 : nomeParticipante.hashCode());
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
		PresencaReuniao other = (PresencaReuniao) obj;
		if (nomeParticipante == null) {
			if (other.nomeParticipante != null)
				return false;
		} else if (!nomeParticipante.equals(other.nomeParticipante))
			return false;
		return true;
	}
	
	
	
	
	

}
