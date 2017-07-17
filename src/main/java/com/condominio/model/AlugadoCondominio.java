package com.condominio.model;

public enum AlugadoCondominio {
	
	SIM("Sim"),
	NAO("Não");
	
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	private AlugadoCondominio(String descricao) {
		this.descricao = descricao;
	}
	
	

}
