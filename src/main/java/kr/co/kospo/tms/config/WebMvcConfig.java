package kr.co.kospo.tms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
  // private final long MAX_AGE_SECS = 3600;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    log.info("[addCorsMappings] " + registry);
    // registry
    //   // 모든 경로에 대해
    //   .addMapping("/**")
    //   // Origin이 http://localhost:3000에 대해
    //   .allowedOrigins("http://localhost:3000")
    //   .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
    //   .allowedHeaders("*")
    //   .allowCredentials(true)
    //   .maxAge(MAX_AGE_SECS);
  }

}
