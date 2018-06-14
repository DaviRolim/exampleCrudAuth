package com.sistemas.stand.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "selecao")
public class Selecao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_selecao")
	private Long cdSelecao;

	@Column(name = "nm_selecao")
	private String nmSelecao;

	@OneToMany(mappedBy = "selecao", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public Selecao() {
	}

	public Selecao(Long cdSelecao, String nmSelecao) {
		this.cdSelecao = cdSelecao;
		this.nmSelecao = nmSelecao;
	}

	public Long getCdSelecao() {
		return cdSelecao;
	}

	public void setCdSelecao(Long cdSelecao) {
		this.cdSelecao = cdSelecao;
	}

	public String getNmSelecao() {
		return nmSelecao;
	}

	public void setNmSelecao(String nmSelecao) {
		this.nmSelecao = nmSelecao;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
