package com.sistemas.stand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.stand.model.Autenticador;

public interface AutenticadorRepository extends JpaRepository<Autenticador, Long> {

	public Autenticador findByKey(String key);
	
}
