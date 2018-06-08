package com.sistemas.stand.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jogador")
public class Jogador {
	
	@EmbeddedId
    private JogadorID id;

	@Column(name="nm_jogador")
	private String nmJogador;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_selecao", insertable=false, updatable=false)
	private Selecao selecao;
	
	public Jogador(){}

	public Jogador(JogadorID id, String nmJogador) {
		this.id = id;
		this.nmJogador = nmJogador;
	}

	public JogadorID getId() {
		return id;
	}

	public void setId(JogadorID id) {
		this.id = id;
	}

	public String getNmJogador() {
		return nmJogador;
	}

	public void setNmJogador(String nmJogador) {
		this.nmJogador = nmJogador;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	
	
}
