package com.wolfie.myWeb01.config.shiro;

import com.wolfie.myWeb01.domin.user.Permission;
import com.wolfie.myWeb01.domin.user.Role;
import com.wolfie.myWeb01.domin.user.UserCustom;
import com.wolfie.myWeb01.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        UserCustom userCustom = userService.userRoleAndPermission(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //童儿
        HashSet<String> roles = new HashSet<String>();
        for(Role r : userCustom.getRoleList()){
            roles.add(r.getRolename());
        }
        if("admin".equals(username)){
            roles.add("admin");
        }
        authorizationInfo.setRoles(roles);
        //权限
        HashSet<String> permissions = new HashSet<>();
        for(Permission p : userCustom.getPermissionList()){
            permissions.add(p.getPermissionName());
        }
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();//username
        UserCustom userCustom = userService.findUserCustomByUsername(username);//get user
        if(userCustom == null){
            throw new UnknownAccountException("用户不存在");
        }

        //1)principal：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
        Object principal = userCustom.getUsername();
        //credentials：密码
        Object credentials = userCustom.getPassword();
        //realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = super.getName();
        //加盐
//        ByteSource credentialsSalt = ByteSource.Util.bytes(principal);//用用户名当做盐
        //因为原ByteSource或者SimpleByteSource无法序列化，所以这里自定义一个可序列化的类实现ByteSource,Serializable
        CustomByteSource credentialsSalt = new CustomByteSource((String)principal);//用用户名当做盐


        SimpleAuthenticationInfo authcInfo  = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
        return authcInfo;
    }


}
