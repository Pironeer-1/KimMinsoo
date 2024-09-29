package com.example.mytemplatecode.global.config;

import com.example.mytemplatecode.global.jwt.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final JwtInterceptor jwtInterceptor;

    public WebConfig(JwtInterceptor jwtInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)

                // member 도메인만 jwt 적용되도록
                .addPathPatterns("/api/member/**")
                .excludePathPatterns(
                        "/api/board/**",
                        "/api/member/login",
                        "/api/member/register",
                        "/swagger-ui/**",
                        "/v3/api-docs/**"
                );
    }

}
