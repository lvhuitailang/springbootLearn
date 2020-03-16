package com.wolfie.myWeb01.domin.user;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserCustom extends User implements Serializable {


    private static final long serialVersionUID = 8265603642401268209L;
    private UserInfo userInfo;

    private List<Role> roleList;

    private List<Permission> permissionList;



}
