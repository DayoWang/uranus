package me.wgy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wgy
 * @date 2019/10/2
 */
@EnableEurekaClient
@SpringBootApplication
public class AuthorizationServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(AuthorizationServerApplication.class, args);
  }
}
