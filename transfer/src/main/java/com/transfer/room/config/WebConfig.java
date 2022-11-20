package com.transfer.room.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO: 2022-11-20 잠시 테스트를 위해서 CORS 등록, 스프링 시큐리티가 제공하는 방법으로 전환 필요. 데모 테스트 끝나면 삭제필요
        registry.addMapping("/**")
                .exposedHeaders("X-AUTH-TOKEN")
                .allowCredentials(true)
                .allowedOriginPatterns("*");
    }
}
