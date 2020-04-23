package com.example.demo.common;

import java.security.MessageDigest;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {
	
	@Value("${system.password-sec.salt}")
	private String salt;
	
	public String generatePassayPassword() {
	    PasswordGenerator gen = new PasswordGenerator();
	    CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
	    CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
	    lowerCaseRule.setNumberOfCharacters(2);
	 
	    CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
	    CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
	    upperCaseRule.setNumberOfCharacters(2);
	 
	    CharacterData digitChars = EnglishCharacterData.Digit;
	    CharacterRule digitRule = new CharacterRule(digitChars);
	    digitRule.setNumberOfCharacters(2);
	 
	    CharacterData specialChars = new CharacterData() {
	        public String getErrorCode() {
	            return "ERR:PASSGEN";
	        }
	 
	        public String getCharacters() {
	            return "!@#$%^&*()_+";
	        }
	    };
	    CharacterRule splCharRule = new CharacterRule(specialChars);
	    splCharRule.setNumberOfCharacters(2);
	 
	    String password = gen.generatePassword(10, splCharRule, lowerCaseRule, 
	      upperCaseRule, digitRule);
	    return password;
	}
	
	public String hashPassword(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(salt.getBytes());
		return null;
	}
	
	public String getSalt() {
		return salt;
	}
}
