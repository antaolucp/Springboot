package com.dxh.bookillustration.pojo;


public class Likes {
    Integer atlas_id;
    Integer user_id;


    public Integer getAtlas_id() {
        return atlas_id;
    }

    public void setAtlas_id(Integer atlas_id) {
        this.atlas_id = atlas_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "likes{" +
                "atlas_id=" + atlas_id +
                ", user_id=" + user_id +
                '}';
    }
}
