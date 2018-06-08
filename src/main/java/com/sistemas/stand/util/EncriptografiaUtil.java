package com.sistemas.stand.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncriptografiaUtil {
	
	public static String encriptografarSenha(String senha) {
		String encodedPass = BCrypt.hashpw(senha, BCrypt.gensalt());
		return encodedPass;
		}
	
	public static Boolean checkHash(String password, String encodedPassword) {
		return BCrypt.checkpw(password, encodedPassword);
	}
}
