package me.wgy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

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

  /**
   * ip限流
   */
  @Bean
  public KeyResolver ipKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
  }
}
