package com.example.books.service;

import com.example.books.models.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> getList();
    List<Book> getSortedByTitleList();
    Map<String, List<Book>> getGroupByAuthorList();
    void create(Book book);
    void update(int bookId, Book book);
    void delete(int bookId);
    Book get(int bookId);
}
