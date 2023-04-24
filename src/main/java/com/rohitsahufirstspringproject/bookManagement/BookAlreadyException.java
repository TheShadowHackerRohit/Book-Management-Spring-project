package com.rohitsahufirstspringproject.bookManagement;

public class BookAlreadyException extends RuntimeException{

    public BookAlreadyException(int id){
        super("Book for id "+ id +" already exists in database");
    }
}
