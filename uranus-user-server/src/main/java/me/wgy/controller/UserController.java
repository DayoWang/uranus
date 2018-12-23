package me.wgy.controller;

import me.wgy.log.LoggerManage;
import me.wgy.model.User;
import me.wgy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wgy
 * @date 2018/11/18
 */
@RestController
public class UserController {


  @Autowired
  UserService userService;

  @LoggerManage(description = "创建用户")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public boolean createUser(@RequestParam(value = "name") String name,
      @RequestParam(value = "identity") String identity) {
    User user = new User();
    user.setName(name);
    user.setIdentity(identity);
    try {
      userService.create(user);
      return Boolean.TRUE;
    } catch (Exception e) {
      return Boolean.FALSE;
    }
  }

  @LoggerManage(description = "根据姓名查询用户")
  @RequestMapping(value = "/query/name", method = RequestMethod.GET)
  public User queryByName(@RequestParam(value = "name") String name) {
    return userService.queryByName(name);
  }

  @LoggerManage(description = "根据姓名查询用户")
  @RequestMapping(value = "/query/identity", method = RequestMethod.GET)
  public User queryByIdentity(@RequestParam(value = "identity") String identity) {
    return userService.queryByIdentity(identity);
  }

}