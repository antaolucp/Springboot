package com.dxh.bookillustration.mapper;

import com.dxh.bookillustration.pojo.Book;
import com.dxh.bookillustration.pojo.Chapter;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BookMapper {
    @Select("select * from book order by book_time DESC")
    @Results({
            @Result(column = "book_id",property = "book_id",id=true),
            @Result(property="chapter",column ="book_id",many = @Many(select ="com.dxh.bookillustration.mapper.BookMapper.findByChapterbybookid",fetchType = FetchType.LAZY))

    })
    List<Book> findbybookall();

    @Select("select * from chapter where book_id=#{book_id}")
    List<Chapter> findByChapterbybookid();
}
