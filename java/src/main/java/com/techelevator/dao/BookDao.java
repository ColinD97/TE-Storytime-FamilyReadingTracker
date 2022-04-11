package com.techelevator.dao;

import com.techelevator.model.Book;

public interface BookDao {

    Book createBook(Book book);

    Book getBookById(int id);
}
