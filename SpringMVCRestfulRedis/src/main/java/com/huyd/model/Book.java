package com.huyd.model;

/**
 * Author: huyd
 * Date: 2017/9/10 19:40
 * Description:图书实体
 */
public class Book {
    private long bookid;
    private String name;
    private int number;

    public Book() {
    }

    public Book(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Book(long bookid, String name, int number) {
        this.bookid = bookid;
        this.name = name;
        this.number = number;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}