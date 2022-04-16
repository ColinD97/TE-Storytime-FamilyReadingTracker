package com.techelevator.model;

public class LogReadingDTO {

    private Long user_id;
    private int book_id;
    private int minutes_read;
    private String reading_format;
    private int times_read;
    private boolean past_book;
    private boolean current_book;
    private boolean future_book;
    private String notes;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getMinutes_read() {
        return minutes_read;
    }

    public void setMinutes_read(int minutes_read) {
        this.minutes_read = minutes_read;
    }

    public String getReading_format() {
        return reading_format;
    }

    public void setReading_format(String reading_format) {
        this.reading_format = reading_format;
    }

    public int getTimes_read() {
        return times_read;
    }

    public void setTimes_read(int times_read) {
        this.times_read = times_read;
    }

    public boolean isPast_book() {
        return past_book;
    }

    public void setPast_book(boolean past_book) {
        this.past_book = past_book;
    }

    public boolean isCurrent_book() {
        return current_book;
    }

    public void setCurrent_book(boolean current_book) {
        this.current_book = current_book;
    }

    public boolean isFuture_book() {
        return future_book;
    }

    public void setFuture_book(boolean future_book) {
        this.future_book = future_book;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
