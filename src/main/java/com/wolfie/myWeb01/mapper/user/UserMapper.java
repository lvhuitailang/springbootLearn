package com.wolfie.myWeb01.mapper.user;

import com.wolfie.myWeb01.domin.user.User;
import com.wolfie.myWeb01.domin.user.UserCustom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userMapper")
public interface UserMapper {
    public User findUserById(String id);

    public UserCustom findUserCustomByUsername(String username);

    public List<User> findAll();

    public UserCustom findUserDetailById(String id);

    public UserCustom findUserDetailById2(String id);

    public UserCustom userRoleAndPermission(String username);
}
