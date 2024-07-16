package com.educandoweb.course.dto;

// Classe responsável pela identificação do campo e mensagem correspondente ao erro apresentado
public class FieldMessage {
    
    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
