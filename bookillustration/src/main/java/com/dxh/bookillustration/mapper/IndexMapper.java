package com.dxh.bookillustration.mapper;

import com.dxh.bookillustration.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IndexMapper{
    @Select("select * from label order by label_num")
    List<Label> findlabelall();

    @Select("select a.*,count(l.user_id) atlas_good from atlas a,likes l where a.atlas_id=l.atlas_id group by atlas_id order by count(l.user_id) DESC,atlas_id ASC")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(column = "atlas_id",property = "atlas_id", id=true),
            @Result(property="user",column ="user_id",one = @One(select ="com.dxh.bookillustration.mapper.IndexMapper.findUserById",fetchType = FetchType.EAGER)),
            @Result(property="images",column ="atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.LAZY))
    }
    )
    List<Atlas> findAtlasallhot();

    @Select("select * from (select * from(" +
            "select a.*,count(l.user_id) atlas_good from atlas a,likes l where a.atlas_id=l.atlas_id group by atlas_id) y " +
            "order by atlas_time DESC, atlas_good DESC) a order by atlas_good" +
            " DESC")
            @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(column = "atlas_id",property = "atlas_id", id=true),
            @Result(property="user",column ="user_id",one = @One(select ="com.dxh.bookillustration.mapper.IndexMapper.findUserById",fetchType = FetchType.EAGER)),
            @Result(property="images",column ="atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.LAZY))}
    )
    List<Atlas> findAtlasallhottime();

    @Select("select * from atlas order by atlas_time DESC")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(column = "atlas_id",property = "atlas_id", id=true),
            @Result(property="user",column ="user_id",one = @One(select ="com.dxh.bookillustration.mapper.IndexMapper.findUserById",fetchType = FetchType.EAGER)),
            @Result(property="images",column ="atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.LAZY))
    }
    )
    List<Atlas> findAtlasalltime();

    @Select("select * from book order by book_good DESC limit 5")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property="user",column ="user_id",one = @One(select ="com.dxh.bookillustration.mapper.IndexMapper.findUserById",fetchType = FetchType.EAGER))
    })
    List<Book> findBookallgood();

    @Select("select u.* from user u ,atlas a where u.user_id=a.user_id group by u.user_id order by count(a.atlas_id) DESC limit 12")
    @Results({
            @Result(column = "user_id", property = "user_id",id=true),
            @Result(property = "atlas",column = "user_id",one=@One(select="com.dxh.bookillustration.mapper.IndexMapper.findAtlasbyid",fetchType = FetchType.EAGER))
    })
    List<KUser> findUserallgood();

    @Select("select atlas_id,atlas_name from atlas where user_id=#{user_id}")
    @Results({
            @Result(column = "atlas_id",property = "atlas_id",id=true),
            @Result(property="images",column ="atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.LAZY))
    })
    Atlas findAtlasbyid(Integer user_id);

    @Select("select * from user where user_id =#{user_id}")
    KUser findUserById(Integer user_id);

    @Select("select * from images where atlas_id =#{atlas_id}")
    List<Images> findImageById(Integer atlas_id);


}
