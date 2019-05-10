package com.oauthsystem.server.service;

import com.oauthsystem.server.entity.User;

public interface UserService {
     User findByLoginName(String loginName);
}
