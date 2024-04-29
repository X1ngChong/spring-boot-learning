package org.top.test.config;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.top.test.interceptor.*;

/**
 * @author mqxu
 * @date 2024/3/25
 * @description SpringMvcConfig
 **/
@Configuration
@AllArgsConstructor
public class SpringMvcConfig implements WebMvcConfigurer {


    private final CustomInterceptor customInterceptor;
    private final AuthenticationInterceptor authenticationInterceptor;
    private final LoggingInterceptor loggingInterceptor;
    private final PerformanceInterceptor performanceInterceptor;
    private final ImageInterceptor imageInterceptor;
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration
                ();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(authenticationInterceptor);
       // registry.addInterceptor(customInterceptor);
        //registry.addInterceptor(loggingInterceptor);
       // registry.addInterceptor(performanceInterceptor);
        registry.addInterceptor(imageInterceptor).addPathPatterns("/user/oss");
    }
}