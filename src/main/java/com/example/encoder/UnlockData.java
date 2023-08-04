package com.example.encoder;

public class UnlockData{
    private boolean noColor;
    private String object;
    private String title;
    private String message;
    private String raw;

    public UnlockData() {
        
    }

    public UnlockData(boolean noColor, String object, String title, String message, String raw) {
        this.noColor = noColor;
        this.object = object;
        this.title = title;
        this.message = message;
        this.raw = raw;
    }

    public boolean getNoColor() {
        return noColor;
    }

    public void setNoColor(boolean noColor) {
        this.noColor = noColor;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }
}