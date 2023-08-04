package com.example.encoder;

public class GenerateResponse {
    private boolean success;
    private GenerateData data;

    public GenerateResponse(){

    }

    public GenerateResponse(boolean success, GenerateData data) {
        this.success = success;
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public GenerateData getData() {
        return data;
    }

    public void setData(GenerateData data) {
        this.data = data;
    }
}
