package com.dxh.bookillustration.pojo;


import java.util.Date;
import java.util.List;

public class Book {
    Integer book_id;
    Integer user_id;
    String book_name;//书名
    String book_cover;//书本封面
    String book_time;//时间
    Integer book_looknum;//观看数量
    Integer book_good;//热度
    String book_synopsis;//简介
    KUser user;
    List<Chapter> chapter;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    public String getBook_time() {
        return book_time;
    }

    public void setBook_time(String book_time) {
        this.book_time = book_time;
    }

    public Integer getBook_looknum() {
        return book_looknum;
    }

    public void setBook_looknum(Integer book_looknum) {
        this.book_looknum = book_looknum;
    }

    public Integer getBook_good() {
        return book_good;
    }

    public void setBook_good(Integer book_good) {
        this.book_good = book_good;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public KUser getUser() {
        return user;
    }

    public void setUser(KUser user) {
        this.user = user;
    }

    public List<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }

    public String getBook_synopsis() {
        return book_synopsis;
    }

    public void setBook_synopsis(String book_synopsis) {
        this.book_synopsis = book_synopsis;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", user_id=" + user_id +
                ", book_name='" + book_name + '\'' +
                ", book_cover='" + book_cover + '\'' +
                ", book_time=" + book_time +
                ", book_looknum=" + book_looknum +
                ", book_good=" + book_good +
                ", book_synopsis='" + book_synopsis + '\'' +
                ", user=" + user +
                ", chapter=" + chapter +
                '}';
    }

}
