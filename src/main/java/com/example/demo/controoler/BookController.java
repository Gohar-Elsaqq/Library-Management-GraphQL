package com.example.demo.controoler;

import com.example.demo.entity.Book;
import com.example.demo.successResponseAndErrorResponse.BookResponse;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.BookServices;
import graphql.GraphQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookServices bookServices;

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookServices.findAllBooks();
    }


    @QueryMapping
    public Book getBookById(@Argument Long id) {
        return bookServices.getBookById(id)
                .orElseThrow(() -> new GraphQLException("Book with ID " + id + " not found."));
    }

    @MutationMapping
    public BookResponse addBook(@Argument String title, @Argument String author,
                                @Argument int publicationYear, @Argument String isbn) {
        return bookServices.saveBook( title, author, publicationYear, isbn);
    }
}