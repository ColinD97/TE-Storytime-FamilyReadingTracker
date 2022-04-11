package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST API
 * Routes
 *  - GET /book/{id} - returns single book
 *  - POST /book - create new book in db
 */

public class BookController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    public BookController(BookDao bookDao){
        this.bookDao = bookDao;
    }

    //@GetMapping("/book/{id}")
    @RequestMapping(path="/book/{id}", method= RequestMethod.GET)
    public Book getBook(@PathVariable int id) {
        return bookDao.getBookById(id);
    }

    @RequestMapping(path="/book", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return bookDao.createBook(book);
    }




}
