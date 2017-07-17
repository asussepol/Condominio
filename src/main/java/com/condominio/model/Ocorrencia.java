package com.condominio.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
public class Ocorrencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo_ocorrencia;
	
	@NotNull(message="data de ocorrência é obrigatorio")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataOcorrencia;
	
	@NotEmpty(message="Campo ocorrência obrigatorio!")
	private String nomeOcorrencia;
	
	@NotEmpty(message="Campo descrição obrigatorio!")
	@Size(max=60,message="Adescrição não pode ter mais de 60 caracteres")
	private String descricao;
	
	@NotEmpty(message="Campo Ação tomada obrigatorio!")
	private String acaoTomada;
	
	@NotEmpty(message="Campo observação obrigatorio!")
	private String observacao;
	
	
	@ManyToOne
	@JoinColumn(name="codigo_unidade")
	private Unidades unidade;
	
	
	public Long getCodigo_ocorrencia() {
		return codigo_ocorrencia;
	}
	public void setCodigo_ocorrencia(Long codigo_unidade) {
		this.codigo_ocorrencia = codigo_unidade;
	}
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	public String getNomeOcorrencia() {
		return nomeOcorrencia;
	}
	public void setNomeOcorrencia(String nomeOcorrencia) {
		this.nomeOcorrencia = nomeOcorrencia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAcaoTomada() {
		return acaoTomada;
	}
	public void setAcaoTomada(String acaoTomada) {
		this.acaoTomada = acaoTomada;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String obseravacao) {
		this.observacao = obseravacao;
	}
	
	
	
	public Unidades getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidades unidade) {
		this.unidade = unidade;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_ocorrencia == null) ? 0 : codigo_ocorrencia.hashCode());
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
		Ocorrencia other = (Ocorrencia) obj;
		if (codigo_ocorrencia == null) {
			if (other.codigo_ocorrencia != null)
				return false;
		} else if (!codigo_ocorrencia.equals(other.codigo_ocorrencia))
			return false;
		return true;
	}
	

}
