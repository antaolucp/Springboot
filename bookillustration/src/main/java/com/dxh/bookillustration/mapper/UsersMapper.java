package com.dxh.bookillustration.mapper;

import com.dxh.bookillustration.pojo.Atlas;
import com.dxh.bookillustration.pojo.Fans;
import com.dxh.bookillustration.pojo.KUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UsersMapper {

    @Select(
            "select * from user order by user_time DESC"
    )
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "atlas",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UsersMapper.findAtlasById",fetchType = FetchType.EAGER))
    })
    List<KUser> findUserallnew();

    @Select("select u.* from user u,fan f where u.user_id=f.user_id group by user_id order by count(f.user_id) DESC ")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "atlas",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UsersMapper.findAtlasById",fetchType = FetchType.EAGER))
    })
    List<KUser> findUserallfans();
    @Select("select u.* from user u ,atlas a where u.user_id=a.user_id group by u.user_id order by count(a.atlas_id) DESC" )
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "atlas",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UsersMapper.findAtlasById",fetchType = FetchType.EAGER)),
            @Result(property = "fans",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UsersMapper.findFanByid",fetchType = FetchType.EAGER))
    })
    List<KUser> findUserallcount();

    @Select("select * from atlas where user_id=#{user_id}")
    @Results({
            @Result(column = "atlas_id",property = "atlas_id",id=true),
            @Result(property = "images",column = "Atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.EAGER))
    })
    List<Atlas> findAtlasById(Integer Atlas_id);

    @Select("select * from fan where user_id=#{user_id}")
    List<Fans> findFanByid(Integer user_id);

    @Select("select * from user where user_mail=#{user_mail}")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "atlas",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findAtlasById",fetchType = FetchType.EAGER)),
            @Result(property = "fans",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findfansById2",fetchType = FetchType.EAGER)),
            @Result(property = "follows",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findfollowssById2",fetchType = FetchType.EAGER)),
    })
    KUser findUserBymail(String user_mail);

    @Update(" UPDATE user" +
            "        SET user_password=#{user_password}" +
            "        WHERE user_mail=#{user_mail}")
    void updateUserPassword(KUser user);

    @Update(" UPDATE user" +
            "        SET user_mail=#{user_mail}" +
            "        WHERE user_id=#{user_id}")
    void updataUsermail(KUser user);

    @Insert("Insert into user(user_name,user_mail,user_password,user_icon,user_time,user_role) " +
            "values(#{user_name},#{user_mail},#{user_password},#{user_icon},#{user_time},#{user_role})")
    void InsetUser(KUser user);
}
