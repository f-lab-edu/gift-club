package com.giftclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@SpringBootApplication
@EnableCaching
@EnableRedisHttpSession
public class GiftclubApplication {

    public static void main(final String[] args) {
        SpringApplication.run(GiftclubApplication.class, args);
    }
}
