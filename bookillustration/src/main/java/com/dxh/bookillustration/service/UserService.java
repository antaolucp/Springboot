package com.dxh.bookillustration.service;

import com.dxh.bookillustration.mapper.UserMapper;
import com.dxh.bookillustration.pojo.Atlas;
import com.dxh.bookillustration.pojo.Fans;
import com.dxh.bookillustration.pojo.KUser;
import com.dxh.bookillustration.pojo.Likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public KUser finduserbyid(Integer user_id){
        return userMapper.finduserbyid(user_id);
    }

    public List<Atlas> findlikebyuserid(Integer user_id){ return userMapper.findlikebyuserid(user_id);}

    public void UpdataUser(KUser user){userMapper.UpdataUser(user);}

    public void followsdelete(Fans fans){userMapper.followsdelete(fans);}

    public void followsInsert(Fans fans){userMapper.followsInsert(fans);}

    public void Insertlike(Likes likes){userMapper.Insertlike(likes);}

    public void Deletelike(Likes likes){userMapper.Deletelike(likes);}
}
