package com.oauthsystem.server.mapper;

import com.oauthsystem.server.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;
@Component
public interface UserMapper extends BaseMapper<User> {
}
