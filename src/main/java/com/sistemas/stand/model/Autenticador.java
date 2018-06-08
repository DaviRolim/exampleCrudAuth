package com.sistemas.stand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autenticador")
public class Autenticador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_auth")
	private Long idAuth;

	@Column(name = "token")
	private String token;

	@Column(name = "key")
	private String key;
	
	public Autenticador() {}

	public Autenticador(String token, String key) {
		this.token = token;
		this.key = key;
	}

	public Long getIdAuth() {
		return idAuth;
	}

	public void setIdAuth(Long idAuth) {
		this.idAuth = idAuth;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

	
	
}
