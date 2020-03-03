package com.dxh.bookillustration.controller;

import com.dxh.bookillustration.pojo.Atlas;
import com.dxh.bookillustration.pojo.Book;
import com.dxh.bookillustration.pojo.Chapter;
import com.dxh.bookillustration.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@Controller("BookController")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/user/book")
    public String index(Map map, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,28);
        List<Book> books =bookService.findbybookall();
        PageInfo<Book> pageInfo = new PageInfo<Book>(books);
        map.put("pageInfo",pageInfo);
        map.put("booksnew",books);
        return "book/index";
    }

    public String findnumBychapter(List<Chapter> chapters) throws Exception{
        Integer i=0;
        DecimalFormat df = new DecimalFormat("#,###");
        for(Chapter chapter :chapters){
            BufferedReader br = new BufferedReader(new FileReader("E:/web/asd/www.pzhan.com/"+chapter.getChapter()));
            while(br.read() != -1) {    //读入文本行及其内容
                i++;
            }
        }
        String m = df.format(i);
        return m;
    }
}
