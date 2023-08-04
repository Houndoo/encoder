package com.example.encoder;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


public class TestClient {

    public static void main(String[] args){
        
        String urlUnlock = "http://localhost:8087/unlock";
        String password = "{\"password\": \"ZS@^cj8Bw_r??p4\"}";
        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(password, headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<UnlockResponse> response = restTemplate.exchange(urlUnlock, HttpMethod.POST, entity, UnlockResponse.class);

        UnlockResponse result = response.getBody();

        System.out.println("Unlock: " + result.getSuccess());       
        
        //Password generation call
        String urlGenerate = "http://localhost:8087/generate";

        HttpHeaders generatePasswordHeaders = new HttpHeaders();

        //generatePasswordHeaders.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        //generatePasswordHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> generatePasswordEntity = new HttpEntity<String>(generatePasswordHeaders);

        RestTemplate generatePasswordRestTemplate = new RestTemplate();

        GenerateResponse generatePasswordResult = generatePasswordRestTemplate.getForObject(urlGenerate, GenerateResponse.class);

        if(generatePasswordResult.getSuccess()){
            System.out.println("Password: " + generatePasswordResult.getData().getData());      
        }
    }
}
