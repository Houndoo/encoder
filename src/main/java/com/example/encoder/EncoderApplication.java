package com.example.encoder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Time;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;

@SpringBootApplication
public class EncoderApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EncoderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String inputFile = "src/main/resources/input.csv";
		String key = "key";

		if(args.length == 2) {
			inputFile = args[0];
			key = args[1];
		}
		else {
			
		}

		List<String> lines = Files.readAllLines(Paths.get(inputFile));

		Date date = new Date();
		final String OUTPUT_FILE = "src/main/resources/output_" + date.getTime() + ".csv";
		
		if(Files.exists(Paths.get(OUTPUT_FILE)))
			Files.delete(Paths.get(OUTPUT_FILE));
		Files.createFile(Paths.get(OUTPUT_FILE));

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
			outputLine += "," + generateEncryptedPassword(key, data[1]);

			//write the output line to the output file
			Files.writeString(Paths.get(OUTPUT_FILE), outputLine + '\n', StandardOpenOption.APPEND);
			
			System.out.println(outputLine);
		}
		
	}
	
	String generatePassword() {
		String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
        StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return password;
	}

	String generateEncryptedPassword(String key, String password) {
		TextEncryptor encryptor = Encryptors.text(key, "deadbeef");
		return encryptor.encrypt(password);
	}
}
