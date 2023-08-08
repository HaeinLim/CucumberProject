package com.three.cucumber.serviceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PwRSA {

	public PwRSA() { }
	
	String sha256(String pw, String salt) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			md.update(salt.getBytes());
			byte[] data = md.digest();
			for(byte b : data) {
				sb.append(String.format("%02x", b));
			}
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	String saltMake() {
		String salt = null;
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[16];
			sr.nextBytes(bytes);
			salt = new String(Base64.getEncoder().encode(bytes));
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return salt;
	}
	

	
}
