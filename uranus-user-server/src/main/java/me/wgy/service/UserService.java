package me.wgy.service;

import me.wgy.log.LoggerManage;
import me.wgy.mapper.UserMapper;
import me.wgy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  UserMapper userMapper;

  @LoggerManage(description = "service queryByName方法")
  public void create(User user) {
    userMapper.insert(user);
  }

  @LoggerManage(description = "service queryByName方法")
  public User queryByName(String name) {
    return userMapper.selectByName(name);
  }

  @LoggerManage(description = "service queryByIdentity")
  public User queryByIdentity(String identity) {
    return userMapper.selectByIdentity(identity);
  }
}
