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
		String base64Encoded = Base64.getEncoder().encodeToString(lines.get(0).getBytes());
		byte[] test = Base64.getDecoder().decode(base64Encoded);
		System.out.println("Hello World" + lines + base64Encoded + new String(test));
		
	}

}
