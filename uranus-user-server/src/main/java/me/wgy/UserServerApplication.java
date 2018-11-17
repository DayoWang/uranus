package me.wgy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wgy
 * @date 2018/11/15
 */
@EnableEurekaClient
@SpringBootApplication
public class UserServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserServerApplication.class, args);
  }

}
