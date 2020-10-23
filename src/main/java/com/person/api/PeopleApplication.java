package com.person.api;

import com.person.conf.SwaggerSpringConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@SpringBootApplication
@EnableAutoConfiguration
//@EnableDiscoveryClient
@Import(SwaggerSpringConfig.class)
public class PeopleApplication {
  public static void main(String[] args) {
    SpringApplication.run(PeopleApplication.class, args);
  }

  /**
   * 
   * @param registry.
   */
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

  }

}
