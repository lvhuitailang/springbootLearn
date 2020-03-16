package com.wolfie.myWeb01.service.user;

import com.wolfie.myWeb01.domin.user.User;
import com.wolfie.myWeb01.domin.user.UserCustom;
import com.wolfie.myWeb01.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public User findUserById(String id){
        User user = userMapper.findUserById(id);
        return user;
    }

    public UserCustom findUserCustomByUsername(String username){
        UserCustom userCustom = userMapper.findUserCustomByUsername(username);
        return userCustom;
    }

    public UserCustom findUserDetailById(String id){
        UserCustom userDetailById = userMapper.findUserDetailById(id);
        return userDetailById;
    }

    public UserCustom findUserDetailById2(String id){
        UserCustom userDetailById = userMapper.findUserDetailById2(id);
        return userDetailById;
    }

    public UserCustom userRoleAndPermission(String username){
        UserCustom userDetailById = userMapper.userRoleAndPermission(username);
        return userDetailById;
    }
}
