package com.capstone.project;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionClass {
	
	// encrypts a string with MD5 hash, used for the user password
	public static String enryptMD5(String input) {
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] messageDigest = md.digest(input.getBytes());
			
			BigInteger no = new BigInteger(1, messageDigest);
			
			String hashtext = no.toString(16);
			while(hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
			
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
