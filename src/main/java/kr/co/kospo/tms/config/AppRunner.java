package kr.co.kospo.tms.config;

import java.nio.charset.Charset;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

  private final ApplicationContext context;
  
  @Override
  public void run(ApplicationArguments args) throws Exception {

    Environment env = context.getEnvironment();

    log.info("----------------- env -----------------");
    log.info("spring.profiles.active: " + env.getProperty("spring.profiles.active"));
    log.info("charset: " + Charset.defaultCharset().displayName());
    log.info("port: " + env.getProperty("port"));
    log.info("upload-dir: " + env.getProperty("upload-dir"));
    log.info("console-log-charset: " + env.getProperty("console-log-charset"));
    log.info("----------------- env -----------------");

  }
}