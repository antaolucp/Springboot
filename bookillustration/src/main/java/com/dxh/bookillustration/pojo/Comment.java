package com.dxh.bookillustration.pojo;

public class Comment {
    private Integer comment_id;
    private Integer user_id;
    private Integer atlas_id;
    private String comment;
    private String comment_time;
    private KUser user;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public KUser getUser() {
        return user;
    }

    public void setUser(KUser user) {
        this.user = user;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", atlas_id=" + atlas_id +
                ", comment='" + comment + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", user=" + user +
                '}';
    }
}
