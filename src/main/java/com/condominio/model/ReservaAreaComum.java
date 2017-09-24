package com.condominio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ReservaAreaComum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	@NotNull(message="Campo Data Reserva é obrigatorio!!!")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataReserva;
	@NotEmpty(message="Campo nome do evento é obrigatorio!!!")
	private String nomeEvento;
	@NotNull(message="Campo hora inicio é obrigatorio!!!")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	private Date inicio;
	@NotNull(message="Campo hora fim é obrigatorio!!!")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern="HH:mm")
	private Date fim;
	@NotNull(message="Campo quantidade de Pessoas é obrigatorio!!!")
    private Integer quantidadePessoas;
	
	@ManyToOne
	@JoinColumn(name="idUnidade")
	private Unidades unidades;
	
	@ManyToOne
	@JoinColumn(name="idAreaComum")
	private AreaComum areaComum;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Integer getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(Integer quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	public Unidades getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}

	public AreaComum getAreaComum() {
		return areaComum;
	}

	public void setAreaComum(AreaComum areaComum) {
		this.areaComum = areaComum;
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
		ReservaAreaComum other = (ReservaAreaComum) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
