package com.condominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.model.Ocorrencia;
import com.condominio.repository.Condominios;
import com.condominio.repository.Ocorrencias;

@Service
public class OcorrenciasService {
	
	@Autowired
	Condominios condominios;
	@Autowired
	Ocorrencias ocorrencias;
	
	
	
	public List<Ocorrencia> todaOcorrencias(){
		
		
		List<Ocorrencia> todas=ocorrencias.findAll();
		
		return todas;
	}

}
