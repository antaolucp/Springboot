package com.dxh.bookillustration.pojo;

import java.util.Date;
import java.util.List;

public class KUser {
    Integer user_id;
    String user_name;
    String user_mail;
    String user_password;
    String user_icon;
    String user_area;
    String user_time;
    String user_synopsis;
    String user_role;
    List<Atlas> atlas;
    List<Fans> fans;
    List<Fans> follows;
    List<Likes> likes;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public List<Atlas> getAtlas() {
        return atlas;
    }

    public void setAtlas(List<Atlas> atlas) {
        this.atlas = atlas;
    }

    public String getUser_area() {
        return user_area;
    }

    public void setUser_area(String user_area) {
        this.user_area = user_area;
    }

    public String getUser_time() {
        return user_time;
    }

    public void setUser_time(String user_time) {
        this.user_time = user_time;
    }

    public String getUser_synopsis() {
        return user_synopsis;
    }

    public void setUser_synopsis(String user_synopsis) {
        this.user_synopsis = user_synopsis;
    }

    public List<Fans> getFans() {
        return fans;
    }

    public void setFans(List<Fans> fans) {
        this.fans = fans;
    }

    public List<Fans> getFollows() {
        return follows;
    }

    public void setFollows(List<Fans> follows) {
        this.follows = follows;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "KUser{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_mail='" + user_mail + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_icon='" + user_icon + '\'' +
                ", user_area='" + user_area + '\'' +
                ", user_time=" + user_time +
                ", user_synopsis='" + user_synopsis + '\'' +
                ", user_role='" + user_role + '\'' +
                ", atlas=" + atlas +
                ", fans=" + fans +
                ", follows=" + follows +
                '}';
    }
}
