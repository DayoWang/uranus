package me.wgy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wgy
 * @date 2018/11/10
 */
@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayServerApplication.class, args);
  }

}
