package com.matrangola.springbootdemo.exception;

public class ResourceException extends Exception {
    private ResourceErrorResponse resourceErrorResponse;

    public ResourceException(Class<?> aClass, Long id) {
        super ("Unable to find " + id + " for " + aClass.getName());
        resourceErrorResponse = new ResourceErrorResponse("Not found", aClass.getName(), id);
    }

    public ResourceErrorResponse getResourceErrorResponse() {
        return resourceErrorResponse;
    }
}
