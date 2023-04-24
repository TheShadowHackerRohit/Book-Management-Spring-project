package com.rohitsahufirstspringproject.bookManagement;

import java.awt.*;
import java.util.Objects;
import java.util.Optional;

public class BookService {

    BookRepository bookRepository = new BookRepository();

    // throws the exception if we are not catching it
    public boolean addBook(Book book) throws BookAlreadyException {
       Optional<Book> bookOptional = bookRepository.getById(book.getBookId()); // book is already exits
        if(bookOptional.isPresent()){
            throw new BookAlreadyException(book.getBookId());
        }//no catch here
        return bookRepository.addBook(book);
    }

    // throws the exception if we are not catching it
    public Book getBook(int id) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepository.getById(id); // book is already exits
        if(bookOptional.isEmpty()){
            throw new BookNotFoundException(id);
        }//no catch here
        return bookOptional.get();
    }

    public String updateBook(int id, String title, String author, Integer pages) {
       try {
           Book book = getBook(id);
           if(Objects.nonNull(title)){
               book.setTitle(title);
           }
           if(Objects.nonNull(author)){
               book.setAuthor(author);
           }
           if(Objects.nonNull(pages)){
               book.setPages(pages);
           }
           bookRepository.addBook(book);
           return "book updated";
       }catch (BookNotFoundException exp){
           Book newBook = new Book(id,title,author,pages);
           bookRepository.addBook(newBook);
           return "new book created";
       }


    }
// throws the exception if we are not catching it
    public boolean deleteBook(int id) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepository.getById(id);
        if(bookOptional.isEmpty()){
            throw new BookNotFoundException(id);
        }//no catch here
        bookRepository.removeById(id);
        return true;
    }
}
