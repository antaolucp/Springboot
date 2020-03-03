package com.dxh.bookillustration.pojo;

public class Images {
    Integer image_id;//图片id
    String image;//图片路径
    Integer user_id;//作者id
    Integer atlas_id;//图册id

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAtlas_id() {
        return atlas_id;
    }

    public void setAtlas_id(Integer atlas_id) {
        this.atlas_id = atlas_id;
    }

    @Override
    public String toString() {
        return "Images{" +
                "image_id=" + image_id +
                ", image='" + image + '\'' +
                ", user_id=" + user_id +
                ", atlas_id=" + atlas_id +
                '}';
    }
}
