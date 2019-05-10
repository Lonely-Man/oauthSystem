package com.oauthsystem.server.mapper;

import com.oauthsystem.server.entity.OauthClient;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Component
public interface OauthClientMapper extends BaseMapper<OauthClient> {
    @Select("select * from oauth_client where clientId=#{clientId}")
    List<OauthClient> findByClientId(String clientId);

}
