package com.dxh.bookillustration.pojo;

import java.util.Date;
import java.util.List;

public class Atlas {
    Integer atlas_id;
    String atlas_name;
    Integer user_id;
    String atlas_time;
    Integer atlas_looknum;
    String atlas_synopsis;
    KUser user;
    List<Images> images;
    public void hh(){}
    public Integer getAtlas_id() {
        return atlas_id;
    }

    void sad(String s) {

    }
    public void setAtlas_id(Integer atlas_id) {
        this.atlas_id = atlas_id;
    }

    public String getAtlas_name() {
        return atlas_name;
    }

    public void setAtlas_name(String atlas_name) {
        this.atlas_name = atlas_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAtlas_time() {
        return atlas_time;
    }

    public void setAtlas_time(String atlas_time) {
        this.atlas_time = atlas_time;
    }

    public Integer getAtlas_looknum() {
        return atlas_looknum;
    }

    public void setAtlas_looknum(Integer atlas_looknum) {
        this.atlas_looknum = atlas_looknum;
    }

    public KUser getUser() {
        return user;
    }

    public void setUser(KUser user) {
        this.user = user;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getAtlas_synopsis() {
        return atlas_synopsis;
    }

    public void setAtlas_synopsis(String atlas_synopsis) {
        this.atlas_synopsis = atlas_synopsis;
    }


    @Override
    public String toString() {
        return "Atlas{" +
                "atlas_id=" + atlas_id +
                ", atlas_name='" + atlas_name + '\'' +
                ", user_id=" + user_id +
                ", atlas_time=" + atlas_time +
                ", atlas_looknum=" + atlas_looknum +
                ", atlas_synopsis='" + atlas_synopsis + '\'' +
                ", user=" + user +
                ", images=" + images +
                '}';
    }



        }
