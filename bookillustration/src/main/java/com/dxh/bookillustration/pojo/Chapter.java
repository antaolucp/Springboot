package com.dxh.bookillustration.pojo;

public class Chapter {
    Integer chapter_id;
    Integer book_id;
    String chapter_name;
    String chapter;
    Integer user_Id;

    public Integer getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapter_id=" + chapter_id +
                ", book_id=" + book_id +
                ", chapter_name='" + chapter_name + '\'' +
                ", chapter='" + chapter + '\'' +
                ", user_Id=" + user_Id +
                '}';
    }
}
