package com.example.encoder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EncoderApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EncoderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<String> lines = Files.readAllLines(Paths.get("src/main/resources/input.csv"));

		for (String line : lines) {
			//Split up the comma seperated data values into a string array
			String[] data = line.split(",");

			//generate a new password if one does not already exist
			if(data.length == 1) {	
				data = new String[] {data[0], generatePassword()};
			}	

			//add the username to the output line
			String outputLine = data[0];
			
			//add the base64 encoded password to the outputLine
			outputLine += "," + Base64.getEncoder().encodeToString(lines.get(0).getBytes());

			//add the encrypted password to the outputLine
			outputLine += "," + generateEncryptedPassword(data[1]);

			//write the output line to the output file
			System.out.println(outputLine);
		}
		
	}
	
	String generatePassword() {
		return "password";
	}

	String generateEncryptedPassword(String password) {
		return "EncryptedPassword";
	}
}
