package com.wolfie.myWeb01.controller.login.Login;

import com.wolfie.myWeb01.domin.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes, User user){

        if("post".equalsIgnoreCase(request.getMethod())){
            // 根据用户名和密码创建 Token
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            // 获取 subject 认证主体
            Subject subject = SecurityUtils.getSubject();
            try{
                // 开始认证，这一步会跳到我们自定义的 Realm 中
                subject.login(token);
                request.getSession().setAttribute("user", user);
                return "login/success";
            }catch (IncorrectCredentialsException e){
                e.printStackTrace();
                request.setAttribute("error", "用户名或密码错误！");
                redirectAttributes.addFlashAttribute("error","用户名或密码错误！");
            }catch(Exception e){
                e.printStackTrace();
                request.setAttribute("error", "未知错误！");
                redirectAttributes.addFlashAttribute("error","用户名或密码错误！");
            }
            return "login/login";
        }else{
            return "login/login";
        }


    }


    @RequestMapping("/success")
    public String success(HttpServletRequest request){

        return "login/success";
    }
}
