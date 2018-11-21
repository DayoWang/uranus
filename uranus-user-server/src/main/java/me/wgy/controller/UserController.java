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

  @LoggerManage(description = "controller hello方法")
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(@RequestParam(value = "userName") String userName) {
    User user = new User();
    user.setName(userName);
    return userService.hello(user);
  }

}
