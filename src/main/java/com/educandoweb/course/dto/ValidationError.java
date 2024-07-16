package com.educandoweb.course.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

// Classe responsável pela criação de uma lista de erros na resposta do CustomError
public class ValidationError extends CustomError{
    
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
    
    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName, message));
    }
}
