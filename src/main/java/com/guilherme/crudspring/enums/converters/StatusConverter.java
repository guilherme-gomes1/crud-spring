package com.guilherme.crudspring.enums.converters;

import java.util.stream.Stream;

import com.guilherme.crudspring.enums.Status;

import jakarta.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        if(status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if(value == null) {
            return null;
        }

        return Stream.of(Status.values())
            .filter(s -> s.getValue().equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    
    }
}
