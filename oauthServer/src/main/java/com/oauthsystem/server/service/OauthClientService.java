package com.oauthsystem.server.service;

import com.oauthsystem.server.entity.OauthClient;
import com.oauthsystem.server.entity.User;

public interface OauthClientService {
    OauthClient findByClientId(String clientId);
    String createAndSaveTokenCode(User user);

}
