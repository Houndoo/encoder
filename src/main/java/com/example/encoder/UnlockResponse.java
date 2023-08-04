package com.example.encoder;

public class UnlockResponse {
    private String success;
    private UnlockData data;

    public UnlockResponse(){

    }

    public UnlockResponse(String success, UnlockData data) {
        this.success = success;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public UnlockData getData() {
        return data;
    }

    public void setData(UnlockData data) {
        this.data = data;
    }
}
