package com.wolfie.myWeb01.domin.user;


import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -7100564464038146229L;


    private String id;

    private String permissionName;

}
