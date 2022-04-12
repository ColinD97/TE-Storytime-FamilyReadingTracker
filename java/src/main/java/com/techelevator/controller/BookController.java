package com.techelevator.controller;


import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path="/book", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return bookDao.createBook(book);
    }




}