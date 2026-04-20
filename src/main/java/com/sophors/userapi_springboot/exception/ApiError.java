package com.sophors.userapi_springboot.exception;

import java.time.LocalDateTime;

public class ApiError {

    private String title;
    private int code;
    private String message;
    private String path;
    private LocalDateTime timestamp;

    public ApiError(String title, int code, String message, String path) {
        this.title = title;
        this.code = code;
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public String getTitle() { return title; }
    public int getCode() { return code; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
    public LocalDateTime getTimestamp() { return timestamp; }
}