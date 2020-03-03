package com.dxh.bookillustration.service;

import com.dxh.bookillustration.mapper.UsersMapper;
import com.dxh.bookillustration.pojo.KUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(1);
        List<GrantedAuthority> authorities = new ArrayList<>();
        KUser user=usersMapper.findUserBymail(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        authorities.add(new SimpleGrantedAuthority(user.getUser_role()));

        return new User(user.getUser_mail(),user.getUser_password(),authorities);
    }
}
