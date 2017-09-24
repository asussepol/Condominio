package com.condominio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.model.PresencaReuniao;
import com.condominio.model.Reuniao;
import com.condominio.repository.PresencaReunioes;

@Service
public class PresencaReunioesService {
	
	@Autowired
	PresencaReunioes presencaReunioes;
	
	
	
	@Transactional
	public PresencaReuniao salvar(PresencaReuniao presencaReuniao){
		
		return presencaReunioes.save(presencaReuniao);
	}
	
public List<PresencaReuniao> listar(){
		
		List<PresencaReuniao> todas= presencaReunioes.findAll();
		
		return todas;
		
	}


public void delete(Long codigo){
	
	presencaReunioes.delete(codigo);
	
}
	

}
