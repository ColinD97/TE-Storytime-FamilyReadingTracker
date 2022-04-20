package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.LogReadingDTO;
import com.techelevator.model.UserBook;
import com.techelevator.model.UserDetailDTO;

import java.util.List;

public interface BookDao {

    Book createBook(Book book, Long readerId);

    Book getBookById(int id);

    List <Book> getBooksByUserId(int id);

    List <Book> getAllBooks();

    boolean createLogEntry(LogReadingDTO entry);

    List <LogReadingDTO> getUserBooks(long id);

    List <LogReadingDTO> getFamilyUserBooks(int id);

    List<Book> getBooksByFamilyId(String familyId);

    List<UserDetailDTO> getUserDetails(long detail_id);

    List <LogReadingDTO> getReadingLog (long user_id);
}
