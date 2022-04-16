package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.LogReadingDTO;
import com.techelevator.model.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API
 * Routes
 *  - GET /book/{id} - returns single book
 *  - POST /book - create new book in db
 */

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
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

        /*
        try {
            User user = userDao.findByUsername(newUser.getUsername());
        } catch (UsernameNotFoundException e) {
            System.out.println("failed to return book");
        }
         */
    }

    @RequestMapping(path="/bookshelf/{id}", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book, @PathVariable String id){
        long readerId = Long.parseLong(id);
        return bookDao.createBook(book, readerId);
    }

    @RequestMapping(value = "/bookshelf/{id}", method = RequestMethod.GET)
    public List<UserBook> getBooksByUser(@PathVariable long id) {
        return bookDao.getBooksByUserId(id);
    }

    @RequestMapping(value="/bookshelf", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @RequestMapping(value="/readinglog", method = RequestMethod.POST)
    public boolean createLogEntry(@RequestBody LogReadingDTO entry) {
        return bookDao.createLogEntry(entry);
    }
}
