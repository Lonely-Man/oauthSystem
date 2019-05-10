package com.oauthclient.util;

import java.util.UUID;

public class UUIDUtils {
    /**
     * 生成uuid
     * @return
     */
    public  static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成clientId
     * @return
     */
    public  static String createClientId(){
        return UUID.randomUUID().toString();

    }
}
