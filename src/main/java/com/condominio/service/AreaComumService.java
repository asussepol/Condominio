package com.condominio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.model.AreaComum;
import com.condominio.model.Reuniao;
import com.condominio.repository.AreaComuns;

@Service
public class AreaComumService {

	@Autowired
	AreaComuns areaComuns;

	@Transactional
	public AreaComum salvar(AreaComum areaComum) {

		return areaComuns.save(areaComum);
	}

	public List<AreaComum> listar() {

		List<AreaComum> todas = areaComuns.findAll();

		return todas;

	}

	public void delete(Long codigo) {

		areaComuns.delete(codigo);

	}

}
