package com.wolfie.myWeb01.domin.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -5540389636231970896L;

    private String id;
    private String userId;

    private String name;
    private String gender;
    private String age;
    private String birthday;
}
