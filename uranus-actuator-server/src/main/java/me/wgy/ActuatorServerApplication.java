package me.wgy;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wgy
 * @date 2018/11/18
 */
@EnableEurekaClient
@SpringBootApplication
@EnableAdminServer
public class ActuatorServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActuatorServerApplication.class, args);
  }
}
