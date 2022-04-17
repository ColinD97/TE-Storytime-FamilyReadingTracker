package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.LogReadingDTO;
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
    public Book createBook(Book bookData, Long readerId) {
        String sql ="INSERT INTO book_info (title, author, isbn, difficulty) VALUES (?,?,?,?) RETURNING book_id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class,
                bookData.getTitle(), bookData.getAuthor(), bookData.getIsbn(), bookData.getDifficulty());
        sql = "INSERT INTO users_books (user_id, book_id, minutes_read, reading_format, times_read, past_book, " +
                "current_book, future_book, notes) VALUES (?, ?, 0, 'Paper', 0, false, false, true, '');";
        jdbcTemplate.update(sql, readerId, id);
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
    public List <UserBook> getBooksByUserId(Long userId) {
        String sql = "SELECT book_info.book_id, title, author, isbn, difficulty, times_read, past_book, " +
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

    @Override
    public boolean createLogEntry(LogReadingDTO entry) {
        String sql = "INSERT INTO users_books (user_id, book_id, minutes_read, " +
                "reading_format, times_read, past_book, current_book, future_book, " +
                "notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        int value = jdbcTemplate.update(sql, entry.getUser_id(),
                entry.getBook_id(), entry.getMinutes_read(), entry.getReading_format(),
                entry.getTimes_read(), entry.isPast_book(), entry.isCurrent_book(),
                entry.isFuture_book(), entry.getNotes());
        return (value == 1);
    }

    @Override
    public List<LogReadingDTO> getUserBooks(long id) {
        String sql = "SELECT * FROM users_books WHERE user_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, id);
        List <LogReadingDTO> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(mapRowToLogReading(resultSet));
        }
        return results;
    }

    @Override
    public List<LogReadingDTO> getFamilyUserBooks(int id) {
        String sql = "SELECT * FROM users_books WHERE family_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, id);
        List <LogReadingDTO> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(mapRowToLogReading(resultSet));
        }
        return results;
    }

    private LogReadingDTO mapRowToLogReading(SqlRowSet resultSet) {
        LogReadingDTO log = new LogReadingDTO();
        log.setUser_id(resultSet.getLong("user_id"));
        log.setBook_id(resultSet.getInt("book_id"));
        log.setMinutes_read(resultSet.getInt("minutes_read"));
        log.setReading_format(resultSet.getString("reading_format"));
        log.setTimes_read(resultSet.getInt("times_read"));
        log.setPast_book(resultSet.getBoolean("past_book"));
        log.setCurrent_book(resultSet.getBoolean("current_book"));
        log.setFuture_book(resultSet.getBoolean("future_book"));
        log.setNotes(resultSet.getString("notes"));
        return log;
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
