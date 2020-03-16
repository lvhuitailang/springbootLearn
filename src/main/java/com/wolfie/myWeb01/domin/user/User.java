package com.wolfie.myWeb01.domin.user;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -2758759096352202386L;


    private String id;
    private String username;
    private String password;


}
