package com.sistemas.stand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemas.stand.model.Jogador;
import com.sistemas.stand.model.JogadorID;

public interface JogadorRepository extends JpaRepository<Jogador, JogadorID> {

}
