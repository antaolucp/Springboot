package com.dxh.bookillustration.service;

import com.dxh.bookillustration.mapper.IndexMapper;
import com.dxh.bookillustration.pojo.Atlas;
import com.dxh.bookillustration.pojo.Book;
import com.dxh.bookillustration.pojo.Label;
import com.dxh.bookillustration.pojo.KUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService{
    @Autowired
    IndexMapper indexMapper;

    public List<Label> findlabelall(){ return indexMapper.findlabelall(); }

    public List<Atlas> findAtlasallhot(){
        return indexMapper.findAtlasallhot();
    }

    public List<Atlas> findAtlasalltime(){
        return indexMapper.findAtlasalltime();
    }

    public List<Book> findBookallgood(){ return indexMapper.findBookallgood();}

    public List<KUser> findUserallgood(){ return indexMapper.findUserallgood();}

    public List<Atlas> findAtlasallhottime(){ return indexMapper.findAtlasallhottime();}
}
