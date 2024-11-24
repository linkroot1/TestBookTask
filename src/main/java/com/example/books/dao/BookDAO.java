package com.example.books.dao;

import com.example.books.models.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getList();
    Book get(int id);
    void save(Book book);
    void delete(int id);
    void update(int id, Book updatedBook);
}
