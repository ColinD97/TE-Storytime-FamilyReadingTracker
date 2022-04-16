package com.techelevator.model;

public class LogReadingDTO {

    private Long userId;
    private int bookId;
    private int minutesRead;
    private String readingFormat;
    private int timesRead;
    private boolean pastBook;
    private boolean currentBook;
    private boolean futureBook;
    private String notes;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMinutesRead() {
        return minutesRead;
    }

    public void setMinutesRead(int minutesRead) {
        this.minutesRead = minutesRead;
    }

    public String getReadingFormat() {
        return readingFormat;
    }

    public void setReadingFormat(String readingFormat) {
        this.readingFormat = readingFormat;
    }

    public int getTimesRead() {
        return timesRead;
    }

    public void setTimesRead(int timesRead) {
        this.timesRead = timesRead;
    }

    public boolean isPastBook() {
        return pastBook;
    }

    public void setPastBook(boolean pastBook) {
        this.pastBook = pastBook;
    }

    public boolean isCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(boolean currentBook) {
        this.currentBook = currentBook;
    }

    public boolean isFutureBook() {
        return futureBook;
    }

    public void setFutureBook(boolean futureBook) {
        this.futureBook = futureBook;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
