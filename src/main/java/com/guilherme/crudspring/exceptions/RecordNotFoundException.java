package com.guilherme.crudspring.exceptions;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Curso não encontardo com o id: " + id);
    }
}
