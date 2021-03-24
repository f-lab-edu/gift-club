package com.giftclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GiftclubApplication {

    public static void main(final String[] args) {
        SpringApplication.run(GiftclubApplication.class, args);
    }
}
