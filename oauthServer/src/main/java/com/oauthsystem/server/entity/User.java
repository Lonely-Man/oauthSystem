package com.oauthsystem.server.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String loginName;
    private String password;
}
