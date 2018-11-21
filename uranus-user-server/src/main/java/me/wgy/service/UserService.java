package me.wgy.service;

import me.wgy.log.LoggerManage;
import me.wgy.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @author wgy
 * @date 2018/11/21
 */
@Service
@RefreshScope
public class UserService {

  @Value("${hello.msg}")
  String msg;

  @LoggerManage(description = "service hello方法")
  public String hello(User user) {
    return user.getName() + msg;
  }
}
