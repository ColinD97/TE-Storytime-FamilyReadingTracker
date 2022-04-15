package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.User;
import com.techelevator.model.UserBook;
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
        String sql ="INSERT INTO book_info (title, author, isbn, difficulty) VALUES (?,?,?,?) RETURNING book_id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class,
                bookData.getTitle(), bookData.getAuthor(), bookData.getIsbn(), bookData.getDifficulty());
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
    public List<UserBook> getBooksByUserId(Long userId) {
        String sql = "SELECT book_info.book_id, title, author, isbn,difficulty, times_read, past_book, " +
                "current_book, future_book FROM users JOIN users_books " +
                "ON users.user_id = users_books.user_id JOIN book_info " +
                "ON users_books.book_id = book_info.book_id WHERE users.user_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, userId);
        List <UserBook> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(mapRowToUserBook(resultSet));
        }
        return results;
    }

    @Override
    public List <Book> getAllBooks() {
        String sql = "SELECT * FROM book_info; ";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql);
        List <Book> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(mapRowToBook(resultSet));
        }
        return results;
    }

    private Book mapRowToBook(SqlRowSet resultSet) {
        Book book = new Book();
        book.setBook_id(resultSet.getInt("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getLong("isbn"));
        book.setDifficulty(resultSet.getInt("difficulty"));
        return book;
    }

    private UserBook mapRowToUserBook(SqlRowSet resultSet) {
        UserBook book = new UserBook();
        book.setBook_id(resultSet.getInt("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setIsbn(resultSet.getLong("isbn"));
        book.setDifficulty(resultSet.getInt("difficulty"));
        book.setTimesRead(resultSet.getInt("times_read"));
        book.setPastBook(resultSet.getBoolean("past_book"));
        book.setCurrentBook(resultSet.getBoolean("current_book"));
        book.setFutureBook(resultSet.getBoolean("future_book"));
        return book;
    }
}
