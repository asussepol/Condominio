package com.condominio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Unidades {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message="valor cpf obrigatorio")
	private String cpf;
	
	@NotEmpty(message="valor nome obrigatorio")
	private String nome;
	
	@NotEmpty(message="valor numero unidade obrigatorio")
	private String numeroUnidade;
	
	@Enumerated(EnumType.STRING)
	private InativoCondominio inativo;
	
	@NotEmpty(message="O Valor telefone não pode ser nulo!")
	private String telefone;
	
	
	@Enumerated(EnumType.STRING)
	private AlugadoCondominio alugado;
	
	@NotEmpty(message="Campo telefone não pode ser nulo!")
	private String email;
	
	@NotNull(message="Valor Fração não pode ser nulo!")
	@NumberFormat(pattern="#####.##")
	private Double fracaoIdeal;
	
	@NotEmpty(message="Campo placa do veiculo não pode ser nulo")
	private String placaVeiculo;
	
	@NotNull(message="numero da garagem não pode ser nulo!")
	private Long numeroGaragem;
	
	@NotNull(message="Area total não pode ser nulo")
	private Double areaTotal;
	
	@OneToMany(mappedBy="unidade", cascade=CascadeType.ALL)
	private List<Ocorrencia> ocorrencias;
	
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	
	@OneToMany(mappedBy="unidades", cascade=CascadeType.ALL)
	public List<ReservaAreaComum> reservas;
	
	public List<ReservaAreaComum> getReservas() {
		return reservas;
	}
	public void setReservas(List<ReservaAreaComum> reservas) {
		this.reservas = reservas;
	}
	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroUnidade() {
		return numeroUnidade;
	}
	public void setNumeroUnidade(String numeroUnidade) {
		this.numeroUnidade = numeroUnidade;
	}
	public InativoCondominio getInativo() {
		return inativo;
	}
	public void setInativo(InativoCondominio inativo) {
		this.inativo = inativo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public AlugadoCondominio getAlugado() {
		return alugado;
	}
	public void setAlugado(AlugadoCondominio alugado) {
		this.alugado = alugado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getFracaoIdeal() {
		return fracaoIdeal;
	}
	public void setFracaoIdeal(Double fracaoIdeal) {
		this.fracaoIdeal = fracaoIdeal;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public Long getNumeroGaragem() {
		return numeroGaragem;
	}
	public void setNumeroGaragem(Long numeroGaragem) {
		this.numeroGaragem = numeroGaragem;
	}
	public Double getAreaTotal() {
		return areaTotal;
	}
	public void setAreaTotal(Double areaTotal) {
		this.areaTotal = areaTotal;
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
		Unidades other = (Unidades) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	public boolean isPendente(){
		
		return AlugadoCondominio.SIM.equals(this.alugado);
	}	
		
	

	
	
	

}
