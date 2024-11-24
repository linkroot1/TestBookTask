package com.example.books.controllers;


import com.example.books.dao.BookDAO;
import com.example.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping(path = "/books", produces = "application/json")
    public List<Book> index() {
        return bookDAO.getList();
    }

    @GetMapping(path = "/sorted-books", produces = "application/json")
    public List<Book> indexSortedByTitle() {
        List<Book> books = bookDAO.getList();

        //Сортировка списка книг по названию в обратном алфавитном порядке
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/grouped-books", produces = "application/json")
    public Map<String, List<Book>> indexGroupByAuthor() {
        List<Book> books = bookDAO.getList();

        //Группировка книг по автору
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @PostMapping(path = "/create", produces = "application/json")
    public void create(@RequestBody Book book) {
        bookDAO.save(book);
    }
}
