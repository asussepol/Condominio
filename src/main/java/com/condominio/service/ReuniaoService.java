package com.condominio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.model.Reuniao;
import com.condominio.repository.Reunioes;

@Service
public class ReuniaoService {
	
	@Autowired
	Reunioes reunioes;
	
	
	
	@Transactional
	public Reuniao salvar(Reuniao reuniao){
		
		return reunioes.save(reuniao);
	}
	
	
	public List<Reuniao> listar(){
		
		List<Reuniao> todas= reunioes.findAll();
		
		return todas;
		
	}
	
	
	public void delete(Long codigo){
		
		reunioes.delete(codigo);
		
	}

}
