package com.sophors.userapi_springboot.response;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private String title;
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse(String title, int code, String message, T data) {
        this.title = title;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public String getTitle() { return title; }
    public int getCode() { return code; }
    public String getMessage() { return message; }
    public T getData() { return data; }
    public LocalDateTime getTimestamp() { return timestamp; }
}