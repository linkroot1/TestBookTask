package com.example.books.controllers;


import com.example.books.models.Book;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/books", produces = "application/json")
    public List<Book> getList() {
        return bookService.getList();
    }

    @GetMapping(path = "/sorted-books", produces = "application/json")
    public List<Book> getSortedByTitleList() {
        return bookService.getSortedByTitleList();
    }

    @GetMapping(path = "/grouped-books", produces = "application/json")
    public Map<String, List<Book>> getGroupByAuthorList() {
        return bookService.getGroupByAuthorList();
    }

    @PostMapping(path = "/create", produces = "application/json")
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @PostMapping(path = "/update/{bookId}", produces = "application/json")
    public void update(@PathVariable int bookId, @RequestBody Book book) {
        bookService.update(bookId, book);
    }

    @DeleteMapping(path = "/delete/{bookId}")
    public void delete(@PathVariable int bookId) {
        bookService.delete(bookId);
    }

    @GetMapping(path = "/{bookId}", produces = "application/json")
    public Book get(@PathVariable int bookId) {
        return bookService.get(bookId);
    }
}
