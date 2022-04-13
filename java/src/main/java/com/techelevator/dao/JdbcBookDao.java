package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Book createBook(Book bookData) {
        String sql ="INSERT INTO book_info (title, author, isbn) VALUES (?,?,?) RETURNING book_id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class,
                bookData.getTitle(), bookData.getAuthor(), bookData.getIsbn());
        return getBookById(id);
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT * FROM book_info WHERE book_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, id);
        Book result = null;
        if (resultSet.next()) {
            result = mapRowToBook(resultSet);
        }
        return result;
    }

    @Override
    public List<Book> getBooksByUserId(Long userId) {
        String sql = "SELECT title, author, isbn, times_read, past_book, " +
                "current_book, future_book FROM users JOIN users_books " +
                "ON users.user_id = users_books.user_id JOIN book_info " +
                "ON users_books.book_id = book_info.book_id WHERE users.user_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, userId);
        List <Book> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(mapRowToUserBook(resultSet));
        }
        return results;
    }

    private Book mapRowToBook(SqlRowSet resultSet) {
        Book book = new Book();
        book.setBook_id(resultSet.getInt("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getInt("isbn"));
        return book;
    }

    private Book mapRowToUserBook(SqlRowSet resultSet) {
        Book book = new Book();
        book.setBook_id(resultSet.getInt("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getInt("isbn"));
        return book;
    }
}
