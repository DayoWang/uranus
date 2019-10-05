package me.wgy.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * 自定义限流标志的key，多个维度
 * exchange对象中获取服务ID、请求信息，用户信息等
 *
 * @author wgy
 * @date 2019/10/5
 */
@Configuration
public class RequestRateLimiterConfig {
  /**
   * ip地址限流
   *
   * @return 限流key
   */
  @Bean
  @Primary
  public KeyResolver remoteAddressKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
  }

  /**
   * 请求路径限流
   *
   * @return 限流key
   */
  @Bean
  public KeyResolver apiKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getPath().value());
  }

  /*
  @Bean
  public KeyResolver userKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
  }*/
}
