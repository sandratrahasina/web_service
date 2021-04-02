package com.ws.ws.helper;

public class FormatResponse 
{
    int status;
    String message;
    Object data;
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return this.data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public FormatResponse(int status, String message, Object data) {
        this.setStatus(status);
        this.setMessage(message);
        this.setData(data);
    }
    public FormatResponse() {
        
    }
}
