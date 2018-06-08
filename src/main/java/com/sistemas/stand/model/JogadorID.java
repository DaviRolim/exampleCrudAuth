package com.sistemas.stand.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JogadorID implements Serializable{
	
	private static final long serialVersionUID = 219829619L;

	@Column(name = "id_jogador")
    private Long idJogador;
 
    @Column(name = "cd_selecao")
    private Long cdSelecao;
    
    public JogadorID() {
	}

	public JogadorID(Long idJogador, Long cdSelecao) {
		this.idJogador = idJogador;
		this.cdSelecao = cdSelecao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdSelecao == null) ? 0 : cdSelecao.hashCode());
		result = prime * result + ((idJogador == null) ? 0 : idJogador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogadorID other = (JogadorID) obj;
		if (cdSelecao == null) {
			if (other.cdSelecao != null)
				return false;
		} else if (!cdSelecao.equals(other.cdSelecao))
			return false;
		if (idJogador == null) {
			if (other.idJogador != null)
				return false;
		} else if (!idJogador.equals(other.idJogador))
			return false;
		return true;
	}
	
	
	
	
    
    
	
}
