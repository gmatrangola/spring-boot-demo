package com.matrangola.springbootdemo.exception;

public class ResourceErrorResponse {
    private final String reason;
    private final String className;
    private final Long id;

    public ResourceErrorResponse(String reason, String className, Long id) {
        this.reason = reason;
        this.className = className;
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public String getClassName() {
        return className;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ResourceErrorResponse{" +
                "reason='" + reason + '\'' +
                ", className='" + className + '\'' +
                ", id=" + id +
                '}';
    }
}
