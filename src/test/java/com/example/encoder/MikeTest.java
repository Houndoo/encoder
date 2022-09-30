package com.example.encoder;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class MikeTest {
    public static void main(String[] args) throws Exception {
        TextEncryptor encryptor = Encryptors.text("mike", "deadbeef");
        System.out.println(encryptor.encrypt("austin"));
    }

}
