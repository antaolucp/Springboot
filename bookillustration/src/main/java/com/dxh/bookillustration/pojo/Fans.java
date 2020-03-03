package com.dxh.bookillustration.pojo;

public class Fans {
    Integer fan_id;
    Integer user_id;
    KUser fan;
    KUser user;

    public Integer getFan_id() {
        return fan_id;
    }

    public void setFan_id(Integer fan_id) {
        this.fan_id = fan_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public KUser getFan() {
        return fan;
    }

    public void setFan(KUser fan) {
        this.fan = fan;
    }

    public KUser getUser() {
        return user;
    }

    public void setUser(KUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Fans{" +
                "fan_id=" + fan_id +
                ", user_id=" + user_id +
                ", fan=" + fan +
                ", user=" + user +
                '}';
    }
}
