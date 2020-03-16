package com.wolfie.myWeb01.domin.user;


import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {


    private static final long serialVersionUID = -4613482225457155042L;
    private String id;
    private String rolename;


}
