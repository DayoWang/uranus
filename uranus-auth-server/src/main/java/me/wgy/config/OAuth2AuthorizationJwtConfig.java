package me.wgy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * OAuth2 JWT 配置
 *
 * @author wgy
 * @date 2019/10/2
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationJwtConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey("test-secret");
    return converter;
  }

  @Bean
  public JwtTokenStore jwtTokenStore() {
    return new JwtTokenStore(accessTokenConverter());
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        .authenticationManager(authenticationManager)
        .tokenStore(jwtTokenStore())
        .accessTokenConverter(accessTokenConverter());
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
        .withClient("clientapp")
        .secret("{noop}112233")
        .scopes("read_userinfo")
        .authorizedGrantTypes(
            "password",
            "authorization_code",
            "refresh_token");
  }
}
