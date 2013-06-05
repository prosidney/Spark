package br.com.spark.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	public String createMD5(String text) throws NoSuchAlgorithmException{
		MessageDigest md = null;
		
        md = MessageDigest.getInstance("MD5");  
        BigInteger hash = new BigInteger(1, md.digest(text.getBytes()));
        
        return hash.toString(16);
	}
}

