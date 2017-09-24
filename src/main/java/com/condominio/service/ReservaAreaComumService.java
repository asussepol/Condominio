package com.condominio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condominio.model.AreaComum;
import com.condominio.model.ReservaAreaComum;
import com.condominio.repository.ReservaAreaComuns;

@Service
public class ReservaAreaComumService {

	@Autowired
	ReservaAreaComuns reservaAreaComuns;

	@Transactional
	public ReservaAreaComum salvar(ReservaAreaComum reservaAreaComum) {

		return reservaAreaComuns.save(reservaAreaComum);
			
	}

	public List<ReservaAreaComum> listar() {

		List<ReservaAreaComum> todas = reservaAreaComuns.findAll();

		return todas;

	}

	public void delete(Long codigo) {

		reservaAreaComuns.delete(codigo);

	}
}
