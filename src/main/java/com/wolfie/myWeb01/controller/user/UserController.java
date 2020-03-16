package com.wolfie.myWeb01.controller.user;


import com.wolfie.myWeb01.domin.user.Role;
import com.wolfie.myWeb01.domin.user.User;
import com.wolfie.myWeb01.domin.user.UserCustom;
import com.wolfie.myWeb01.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/findUserById/{id}")
    public User index(@PathVariable String id){
        User user = userService.findUserById(id);

        return user;
    }
    @RequestMapping("/allUsers")
    @ResponseBody
    public String allUsers(){
        StringBuffer sb = new StringBuffer("");
        List<User> userList = userService.findAll();
        for(User u : userList){
            sb.append(u.getUsername()+"<br/>");
        }

        return sb.toString();
    }

    @RequestMapping("/findUserDetailById/{id}")
    @ResponseBody
    public String findUserDetailById(@PathVariable String id){
        UserCustom userCustom = userService.findUserDetailById(id);
        StringBuffer sb = new StringBuffer("");
        sb.append("id:"+userCustom.getId()+"<br/>");
        sb.append("username:"+userCustom.getUsername()+"<br/>");
        sb.append("userInfoId:"+userCustom.getUserInfo().getId()+"<br/>");
        sb.append("userId:"+userCustom.getUserInfo().getUserId()+"<br/>");
        sb.append("name:"+userCustom.getUserInfo().getName()+"<br/>");
        sb.append("gender:"+userCustom.getUserInfo().getGender()+"<br/>");
        sb.append("age:"+userCustom.getUserInfo().getAge()+"<br/>");
        sb.append("birthday:"+userCustom.getUserInfo().getBirthday()+"<br/>");

        return sb.toString();


    }

    @RequestMapping("/findUserDetailById2/{id}")
    @ResponseBody
    public String findUserDetailById2(@PathVariable String id){
        UserCustom userCustom = userService.findUserDetailById2(id);
        StringBuffer sb = new StringBuffer("");
        sb.append("id:"+userCustom.getId()+"<br/>");
        sb.append("username:"+userCustom.getUsername()+"<br/>");
        sb.append("userInfoId:"+userCustom.getUserInfo().getId()+"<br/>");
        sb.append("userId:"+userCustom.getUserInfo().getUserId()+"<br/>");
        sb.append("name:"+userCustom.getUserInfo().getName()+"<br/>");
        sb.append("gender:"+userCustom.getUserInfo().getGender()+"<br/>");
        sb.append("age:"+userCustom.getUserInfo().getAge()+"<br/>");
        sb.append("birthday:"+userCustom.getUserInfo().getBirthday()+"<br/>");
        List<Role> roleList = userCustom.getRoleList();
        sb.append("roleId和rolename:<br/>");
        for(Role role : roleList){
            sb.append("["+role.getId()+"]&nbsp;:"+role.getRolename()+"");

        }

        return sb.toString();


    }
}
