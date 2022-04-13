package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {

    Book createBook(Book book);

    Book getBookById(int id);

    List<Book> getBooksByUserId(Long userId);
}
