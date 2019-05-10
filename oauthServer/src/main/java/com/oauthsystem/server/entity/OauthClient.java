package com.oauthsystem.server.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "oauth_client")
public class OauthClient {
    private String id;
    private String name;
    private String clientId;
    private String clientSecret;
}
