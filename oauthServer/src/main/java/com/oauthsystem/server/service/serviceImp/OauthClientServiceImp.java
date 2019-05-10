package com.oauthsystem.server.service.serviceImp;

import com.oauthsystem.server.entity.OauthClient;
import com.oauthsystem.server.entity.User;
import com.oauthsystem.server.mapper.OauthClientMapper;
import com.oauthsystem.server.service.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OauthClientServiceImp implements OauthClientService {
    @Autowired
    private OauthClientMapper oauthClientMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public OauthClient findByClientId(String clientId) {
        List<OauthClient> list=oauthClientMapper.findByClientId(clientId);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public String createAndSaveTokenCode(User user) {
        String codeToken="";
        redisTemplate.opsForValue().set(codeToken,user.getLoginName());
        redisTemplate.expire(codeToken,5,TimeUnit.MINUTES);
        return null;
    }
}
