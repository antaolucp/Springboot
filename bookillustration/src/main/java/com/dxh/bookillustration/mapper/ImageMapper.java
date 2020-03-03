package com.dxh.bookillustration.mapper;

import com.dxh.bookillustration.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


public interface ImageMapper {

    @Select("select * from atlas order by atlas_looknum DESC")
    @Results({
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(column = "atlas_id",property = "atlas_id", id=true),
            @Result(property="user",column ="user_id",one = @One(select ="com.dxh.bookillustration.mapper.IndexMapper.findUserById",fetchType = FetchType.EAGER)),
            @Result(property="images",column ="atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.LAZY))
    }
    )
    List<Atlas> findMapperonlook();

    @Select("select * from atlas where atlas_id=#{atlas_id}")
    @Results({
            @Result(column = "atlas_id",property = "atlas_id",id = true),
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property="images",column ="atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.LAZY)),
            @Result(property = "user",column ="user_id",one = @One(select ="com.dxh.bookillustration.mapper.ImageMapper.findUserById",fetchType = FetchType.EAGER)),

    })
    Atlas findAtlasbyId(Integer atlas_id);

    @Select("select * from comment where atlas_id=#{atlas_id}")
    @Results({
            @Result(column = "user_id",property = "user_id",id= true),
            @Result(property = "user",column = "user_id",one = @One(select = "com.dxh.bookillustration.mapper.IndexMapper.findUserById",fetchType = FetchType.EAGER)),
    })
    List<Comment> findCommentbyId(Integer atlas_id);

    @Select("select * from user where user_id=#{user_id}")
    @Results({
            @Result(column = "user_id",property = "user_id",id = true),
            @Result(property = "atlas",column = "user_id",many = @Many(select = "com.dxh.bookillustration.mapper.UserMapper.findAtlasById",fetchType = FetchType.LAZY))
    })
    KUser findUserById(Integer user_id);

    @Select("select * from likes where atlas_id=#{atlas_id}")
    List<Likes> findlikebyid(Integer atlas_id);

    @Select({
        "<script>" +
                "select * from " +
                    "(select a4.*,count(l.atlas_id) like_num from " +
                        "(select a3.*,count(c.comment_id) comment_num from " +
                            "(select a2.*,b2.fan_num,b2.user_time,b2.atlas_num from atlas a2 left join " +
                                "(select b.*,count(a1.atlas_id) atlas_num from atlas a1 left join " +
                                    "(select u.*,count(f.user_id) fan_num from user u left join fan f on u.user_id=f.user_id group by u.user_id ) b " +
                                    "on a1.user_id=b.user_id group by b.user_id) b2 " +
                                "on a2.user_id=b2.user_id group by a2.atlas_id) a3 left join comment c " +
                            "on a3.atlas_id=c.atlas_id group by a3.atlas_id) a4 left join likes l " +
                        "on a4.atlas_id=l.atlas_id group by a4.atlas_id) a" +
                "<where> " +
                    "<if test=\"time =='2'.toString()\">" +
                        "<![CDATA[ and DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(atlas_time)]]> "+
                    "</if>"+
                    "<if test=\"time =='3'.toString()\">" +
                        "<![CDATA[ and DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(atlas_time)]]> "+
                    "</if>"+
                    "<if test=\"time =='4'.toString()\">" +
                        "<![CDATA[ and DATE_SUB(CURDATE(), INTERVAL 1 YEAR) <= date(atlas_time)]]> "+
                    "</if>"+
                "</where>" +
                "<if test=\"(time !=null and time !='1'.toString()) or (fans !=null and fans !='1'.toString()) or (likes !=null and likes !='1'.toString())\">" +
                    "order by" +
                "</if>"+
                "<if test=\"(time !=null and time !='1'.toString()) and fans =='1'.toString()\">" +
                    "atlas_time DESC"+
                "</if>" +
                "<if test=\"fans =='2'.toString()\">" +
                    "user_time DESC"+
                "</if>" +
                "<if test=\"fans =='3'.toString()\">" +
                    "fan_num DESC"+
                "</if>" +
                "<if test=\"fans =='4'.toString()\">" +
                    "atlas_num DESC"+
                "</if>" +
                "<if test=\"(time !=null and time !='1'.toString() or fans !=null and fans !='1'.toString()) and likes !=null and likes !='1'.toString()\">" +
                    ","+
                "</if>" +
                "<if test=\"likes =='2'.toString()\">" +
                    "like_num DESC" +
                "</if>" +
                "<if test=\"likes =='3'.toString()\">" +
                    "comment_num DESC" +
                "</if>" +

         "</script>"
    })
    @Results({
            @Result(column = "atlas_id",property = "atlas_id",id = true),
            @Result(column = "user_id",property = "user_id",id=true),
            @Result(property="images",column ="atlas_id",many = @Many(select ="com.dxh.bookillustration.mapper.IndexMapper.findImageById",fetchType = FetchType.LAZY)),
            @Result(property = "user",column ="user_id",one = @One(select ="com.dxh.bookillustration.mapper.ImageMapper.findUserById",fetchType = FetchType.EAGER)),

    })
    List<Atlas> findAtlas(@Param("time") String time,@Param("fans") String fans,@Param("likes") String likes);

    @Select("select max(atlas_id) from atlas;")
    Integer findAtlas_id();

    @Insert("Insert into images(image,user_id,atlas_id) values(#{image},#{user_id},#{atlas_id})")
    void InsertImage(Images images);

    @Insert("Insert into atlas(atlas_id,atlas_name,user_id,atlas_synopsis) values(#{atlas_id},#{atlas_name},#{user_id},#{atlas_synopsis})")
    void InsertAtlas(Atlas atlas);
}
