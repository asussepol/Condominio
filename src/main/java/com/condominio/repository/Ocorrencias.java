package com.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominio.model.Ocorrencia;

public interface Ocorrencias extends JpaRepository<Ocorrencia,Long> {

}
