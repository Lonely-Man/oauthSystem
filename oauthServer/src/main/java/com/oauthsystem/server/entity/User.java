package com.oauthsystem.server.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    private String id;
    private String loginName;
    private String password;
    private String clientId;
    private String clientSecret;
}
