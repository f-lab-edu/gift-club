package com.giftclub.common.config;

import com.giftclub.common.security.PasswordEncoder;
import com.giftclub.common.security.PasswordEncoderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoderImpl();
    }
}
