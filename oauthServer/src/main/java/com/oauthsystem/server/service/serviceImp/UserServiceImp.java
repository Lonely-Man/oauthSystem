package com.oauthsystem.server.service.serviceImp;

import com.oauthsystem.server.entity.User;
import com.oauthsystem.server.mapper.UserMapper;
import com.oauthsystem.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByLoginName(String loginName) {
        User user=new User();
        user.setLoginName(loginName);
        List<User> users=userMapper.select(user);
        if (!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
}
