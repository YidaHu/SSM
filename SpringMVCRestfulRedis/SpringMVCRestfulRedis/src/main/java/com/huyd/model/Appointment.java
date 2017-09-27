package com.huyd.model;

import java.util.Date;

/**
 * Author: huyd
 * Date: 2017/9/11 18:42
 * Description:
 */
public class Appointment {
    private int id;
    private int bookid;
    private int studentid;
    private Date appointtime;

    private Book book;

    public Appointment() {
    }

    public Appointment(int bookid, int studentid, Date appointtime) {
        this.bookid = bookid;
        this.studentid = studentid;
        this.appointtime = appointtime;
    }

    public Appointment(int bookid, int studentid, Date appointtime, Book book) {
        this.bookid = bookid;
        this.studentid = studentid;
        this.appointtime = appointtime;
        this.book = book;
    }

    public Appointment(int id, int bookid, int studentid, Date appointtime, Book book) {
        this.id = id;
        this.bookid = bookid;
        this.studentid = studentid;
        this.appointtime = appointtime;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public Date getAppointtime() {
        return appointtime;
    }

    public void setAppointtime(Date appointtime) {
        this.appointtime = appointtime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", studentid=" + studentid +
                ", appointtime=" + appointtime +
                ", book=" + book +
                '}';
    }
}