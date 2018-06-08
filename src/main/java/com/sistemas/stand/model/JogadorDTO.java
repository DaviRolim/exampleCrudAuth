package com.sistemas.stand.model;

public class JogadorDTO {
	
	private Long idJogador;
	private Long cdSelecao;
	private String nmJogador;

	public JogadorDTO() {}

	public JogadorDTO(Long idJogador, Long cdSelecao, String nmJogador) {
		super();
		this.idJogador = idJogador;
		this.cdSelecao = cdSelecao;
		this.nmJogador = nmJogador;
	}

	public Long getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(Long idJogador) {
		this.idJogador = idJogador;
	}

	public Long getCdSelecao() {
		return cdSelecao;
	}

	public void setCdSelecao(Long cdSelecao) {
		this.cdSelecao = cdSelecao;
	}

	public String getNmJogador() {
		return nmJogador;
	}

	public void setNmJogador(String nmJogador) {
		this.nmJogador = nmJogador;
	}
	
	
}
