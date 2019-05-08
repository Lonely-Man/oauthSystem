package com.oauthclient.annotation;

public @interface ApiToken {
     boolean isOpne()default false;
     String value() default "";
}
