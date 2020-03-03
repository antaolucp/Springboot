package com.dxh.bookillustration.mapper;

import com.dxh.bookillustration.pojo.Atlas;
import com.dxh.bookillustration.pojo.Fans;
import com.dxh.bookillustration.pojo.KUser;
import com.dxh.bookillustration.pojo.Likes;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where user_id=#{user_id}")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "atlas",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findAtlasById",fetchType = FetchType.EAGER)),
            @Result(property = "fans",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findfansById",fetchType = FetchType.EAGER)),
            @Result(property = "follows",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findfollowssById",fetchType = FetchType.EAGER)),

    })
    KUser finduserbyid(Integer user_id);

    @Select("select a.* from atlas a,likes l where a.atlas_id=l.atlas_id and l.user_id =#{user_id} group by atlas_id")
    @Results({
            @Result(column = "atlas_id",property = "atlas_id",id=true),
            @Result(property = "images",column = "Atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.EAGER))

    })
    List<Atlas> findlikebyuserid(Integer user_id);

    @Select("select * from fan where user_id=#{user_id}")
    @Results({
            @Result(column = "fan_id",property = "fan_id",id=true),
            @Result(property = "fan",column = "fan_id",one = @One(select ="com.dxh.bookillustration.mapper.UserMapper.finduserfanbyid",fetchType = FetchType.LAZY))
    })
    List<Fans> findfansById(Integer user_id);

    @Select("select * from fan where fan_id=#{fan_id}")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "user",column = "user_id",one = @One(select ="com.dxh.bookillustration.mapper.UserMapper.finduserfanbyid",fetchType = FetchType.LAZY))
    })
    List<Fans> findfollowssById(Integer fan_id);

    @Select("select * from fan where user_id=#{user_id}")
    List<Fans> findfansById2(Integer user_id);

    @Select("select * from fan where fan_id=#{fan_id}")
    List<Fans> findfollowssById2(Integer user_id);

    @Select("select * from user where user_id=#{user_id}")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "fans",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findfansById2",fetchType = FetchType.EAGER)),
            @Result(property = "follows",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findfollowssById2",fetchType = FetchType.EAGER)),
            @Result(property = "atlas",column = "user_id",many = @Many(select ="com.dxh.bookillustration.mapper.UsersMapper.findAtlasById",fetchType = FetchType.EAGER))
    })
    KUser finduserfanbyid(Integer user_id);


    @Select("select * from atlas where user_id=#{user_id}")
    @Results({
            @Result(column = "atlas_id",property = "atlas_id",id=true),
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property = "images",column = "Atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.EAGER))
    })
    List<Atlas> findAtlasById();

    @Select("select * from like where user_id=#{user_id}")
    @Results({
            @Result(column = "atlas_id",property = "atlas_id",id=true),
            @Result(property = "atlas",column = "Atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.EAGER))
    })
    List<Atlas> findlikeById();

    @Update({"<script> " +
            "UPDATE user" +
            "<set>" +
            "   <if test=\"user_name!=null and user_name!=''\">       " +
            "       user_name=#{user_name}," +
            "   </if>" +
            "   <if test=\"user_name!=null and user_name!=''\">        " +
            "       user_area=#{user_area}," +
            "   </if> " +
            "   <if test=\"user_name!=null and user_name!=''\">       " +
            "       user_synopsis=#{user_synopsis}," +
            "   </if> " +
            "   <if test=\"user_icon!=null and user_icon!=''\">" +
            "       user_icon=#{user_icon}" +
            "   </if>" +
            "</set>" +
            "        WHERE user_id=#{user_id}" +
            "</script>"})
    void UpdataUser(KUser user);

    @Delete("Delete from fan where user_id=#{user_id} and fan_id=#{fan_id}")
    void followsdelete(Fans fans);
    @Insert("Insert into fan values(#{fan_id},#{user_id})")
    void followsInsert(Fans fans);

    @Insert("Insert into likes values(#{atlas_id},#{user_id})")
    void Insertlike(Likes likes);

    @Delete("Delete from likes where user_id=#{user_id} and atlas_id=#{atlas_id}")
    void Deletelike(Likes likes);
}
