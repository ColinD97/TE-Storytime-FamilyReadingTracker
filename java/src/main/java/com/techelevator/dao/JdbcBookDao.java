package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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

    private Book mapRowToBook(SqlRowSet resultSet) {
        Book book = new Book();
        book.setBook_id(resultSet.getInt("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getInt("isbn"));
        return book;
    }
}
