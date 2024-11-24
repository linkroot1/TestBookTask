package com.example.books.service.impl;

import com.example.books.dao.BookDAO;
import com.example.books.models.Book;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getList() {
        return bookDAO.getList();
    }

    @Override
    public List<Book> getSortedByTitleList(){
        List<Book> books = bookDAO.getList();

        //Сортировка списка книг по названию в обратном алфавитном порядке
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Book>> getGroupByAuthorList(){
        List<Book> books = bookDAO.getList();

        //Группировка книг по автору
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public void create(Book book) {
        bookDAO.create(book);
    }

    @Override
    public void update(int bookId, Book book) {
        bookDAO.update(bookId, book);
    }

    @Override
    public void delete(int bookId) {
        bookDAO.delete(bookId);
    }

    @Override
    public Book get(int bookId) {
        return bookDAO.get(bookId);
    }
}
