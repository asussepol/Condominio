package com.condominio.model;

public enum InativoCondominio {
	
	SIM("Sim"),
	NAO("Não"),
	NA("Não avaliado");
	
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	private InativoCondominio(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
