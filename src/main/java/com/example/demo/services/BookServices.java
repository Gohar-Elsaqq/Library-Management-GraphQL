package com.example.demo.services;


import com.example.demo.entity.Book;

import com.example.demo.successResponseAndErrorResponse.BookResponse;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }


    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public BookResponse saveBook(String title, String author, int publicationYear, String isbn){
        Book book = new Book(title,author,publicationYear,isbn);
         bookRepository.save(book);
        return new BookResponse("Saved successfully");
    }
}
