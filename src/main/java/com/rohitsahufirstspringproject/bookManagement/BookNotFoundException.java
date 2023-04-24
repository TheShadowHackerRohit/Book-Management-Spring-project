package com.rohitsahufirstspringproject.bookManagement;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(int id){
        super("book does not exist for id: " + id);
    }
}
