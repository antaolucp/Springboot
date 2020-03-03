package com.dxh.bookillustration.service;

import com.dxh.bookillustration.mapper.ImageMapper;
import com.dxh.bookillustration.pojo.Atlas;
import com.dxh.bookillustration.pojo.Comment;
import com.dxh.bookillustration.pojo.Images;
import com.dxh.bookillustration.pojo.Likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageMapper imageMapper;

    public List<Atlas> findMapperonlook(){
        return imageMapper.findMapperonlook();
    }

    public Atlas findAtlasbyId(Integer atlas_id){return imageMapper.findAtlasbyId(atlas_id);}

    public List<Likes> findlikebyId(Integer atlas_id){return imageMapper.findlikebyid(atlas_id);}

    public List<Comment> findCommentById(Integer atlas_id){return imageMapper.findCommentbyId(atlas_id);}

    public List<Atlas> findAtlas(String time,String fans,String likes){ return imageMapper.findAtlas(time,fans,likes);}

    public Integer findAtlas_id(){return imageMapper.findAtlas_id();}

    public void InsertImage(Images images){imageMapper.InsertImage(images);}

    public void InsertAtlas(Atlas atlas){imageMapper.InsertAtlas(atlas);}
}
