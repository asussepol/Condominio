package com.condominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.model.Unidades;
import com.condominio.repository.Condominios;
import com.condominio.repository.Ocorrencias;

@Service
public class UnidadesService {
	
	@Autowired
	private Condominios condominios;
	
	@Autowired
	private Ocorrencias ocorrencias;
	
	
	
	public List<Unidades> todasUnidades(){
		
		List<Unidades> todas = condominios.findAll();
		
		return todas;
	}

}
