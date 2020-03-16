package com.wolfie.myWeb01.domin.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class Userrole implements Serializable {

    private static final long serialVersionUID = -2877271189334179188L;


    private String id;

    private String userId;

    private String roleId;
}
