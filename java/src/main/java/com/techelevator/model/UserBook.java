package com.techelevator.model;

public class UserBook extends Book {

    private int timesRead;
    private boolean pastBook;
    private boolean currentBook;
    private boolean futureBook;

    public UserBook() {
        super();
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
}