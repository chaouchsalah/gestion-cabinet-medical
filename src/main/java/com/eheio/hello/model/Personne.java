package com.eheio.hello.model;

import java.security.*;
import java.security.spec.*;
import java.util.Random;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.*;

@MappedSuperclass
public class Personne {
	@Column(name = "name")
	private String name;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	private static final Random RANDOM = new SecureRandom();
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	byte[] salt = new byte[16];

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		RANDOM.nextBytes(salt);
		this.password = hashPassword(password, salt, ITERATIONS, KEY_LENGTH).toString();
	}
	
	public boolean checkPassword(String password){
		password = hashPassword(password, salt, ITERATIONS, KEY_LENGTH).toString();
		if(this.password.equals(password)){
			return true;
		}
		return false;
	}

	public static byte[] hashPassword(final String password, final byte[] salt, final int iterations,
			final int keyLength) {
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}
}
