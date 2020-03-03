package com.dxh.bookillustration.service;

import com.dxh.bookillustration.mapper.BookMapper;
import com.dxh.bookillustration.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public List<Book> findbybookall(){
        return bookMapper.findbybookall();
    }
}
