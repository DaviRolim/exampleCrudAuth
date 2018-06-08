package com.sistemas.stand.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.stand.model.Autenticador;
import com.sistemas.stand.model.Jogador;
import com.sistemas.stand.model.JogadorDTO;
import com.sistemas.stand.model.JogadorID;
import com.sistemas.stand.model.Selecao;
import com.sistemas.stand.repository.AutenticadorRepository;
import com.sistemas.stand.repository.JogadorRepository;
import com.sistemas.stand.repository.SelecaoRepository;
import com.sistemas.stand.util.EncriptografiaUtil;

@RestController
@RequestMapping(value = "/")
public class SelecaoController {
	
	@Autowired
	private SelecaoRepository selecaoRepository;
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private AutenticadorRepository autenticadorRepository;
	
	@GetMapping
	public ResponseEntity<List<Selecao>> findAllSelecoes(@RequestHeader("token") String token,
														 @RequestHeader("key") String key) {
		
		// Pegue o objeto autenticador (que tem o token encriptografado com essa key)
		Autenticador auth = autenticadorRepository.findByKey(key);

		// Verifica se o token do header bate com o encriptografado
		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			List<Selecao> selecoes = selecaoRepository.findAll();
			return ResponseEntity.accepted().body(selecoes);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping("/filtro")
	public ResponseEntity<Optional<Selecao>> findSelecaoById(@RequestParam Long cdSelecao,
															@RequestHeader("token") String token,
															 @RequestHeader("key") String key) {

		Autenticador auth = autenticadorRepository.findByKey(key);

		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			Optional<Selecao> selecao = selecaoRepository.findById(cdSelecao);
			return ResponseEntity.ok(selecao);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@DeleteMapping("/filtro")
	public HttpStatus deleteSelecao( @RequestParam Long cdSelecao,
										@RequestHeader("token") String token,
										 @RequestHeader("key") String key) {
		Autenticador auth = autenticadorRepository.findByKey(key);

		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			selecaoRepository.deleteById(cdSelecao);
			return HttpStatus.ACCEPTED;
		} else {
			return HttpStatus.UNAUTHORIZED;
		}
	}


	@PostMapping
	public ResponseEntity<Selecao> salvarSelecao(@RequestBody Selecao selecao,
												@RequestHeader("token") String token,
												 @RequestHeader("key") String key) {
		Autenticador auth = autenticadorRepository.findByKey(key);

		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			selecaoRepository.save(selecao);
			return ResponseEntity.ok(selecao);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping("/jogador")
	public ResponseEntity<List<Jogador>> findAllJogadores(@RequestHeader("token") String token,
														 @RequestHeader("key") String key) {
		Autenticador auth = autenticadorRepository.findByKey(key);

		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			List<Jogador> jogadores = jogadorRepository.findAll();
			return ResponseEntity.ok(jogadores);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping("/jogador/filtro")
	public ResponseEntity<Optional<Jogador>> findAllBySelecao(@RequestParam Long idJogador
															, @RequestParam Long cdSelecao,
															 @RequestHeader("token") String token,
															 @RequestHeader("key") String key) {
		Autenticador auth = autenticadorRepository.findByKey(key);

		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			JogadorID id = new JogadorID(idJogador, cdSelecao);
			Optional<Jogador> jogador = jogadorRepository.findById(id);
			return ResponseEntity.ok(jogador);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PostMapping("/jogador")
	public ResponseEntity<Jogador> salvarJogador(@RequestBody JogadorDTO jogadorDto,
												@RequestHeader("token") String token,
												 @RequestHeader("key") String key) {
		Autenticador auth = autenticadorRepository.findByKey(key);

		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			JogadorID id = new JogadorID(jogadorDto.getIdJogador(), jogadorDto.getCdSelecao());
			Jogador jogador = new Jogador(id, jogadorDto.getNmJogador());
			jogadorRepository.save(jogador);
			return ResponseEntity.ok(jogador);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@DeleteMapping("/jogador/filtro")
	public ResponseEntity deleteJogador(@RequestParam Long idJogador
									  , @RequestParam Long cdSelecao
									  , @RequestHeader("token") String token
									  , @RequestHeader("key") String key) {
		Autenticador auth = autenticadorRepository.findByKey(key);

		if (EncriptografiaUtil.checkHash(token, auth.getToken())) {
			JogadorID id = new JogadorID(idJogador, cdSelecao);
			jogadorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PostMapping("/savetoken")
	public ResponseEntity<Autenticador> salvarToken(@RequestBody Autenticador auth) {
		String encodedToken = EncriptografiaUtil.encriptografarSenha(auth.getToken());
		Autenticador novoAuth = new Autenticador(encodedToken, auth.getKey());
		autenticadorRepository.save(novoAuth);
		return ResponseEntity.ok(novoAuth);
	}
}
