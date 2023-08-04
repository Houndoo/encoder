package com.example.encoder;

public class GenerateData {
    private String object;
    private String data;

    public GenerateData(){

    }

    public GenerateData(String object, String data) {
        this.object = object;
        this.data = data;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
