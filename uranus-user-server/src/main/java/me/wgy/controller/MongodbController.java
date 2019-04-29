package me.wgy.controller;

import io.swagger.annotations.ApiOperation;
import me.wgy.log.LoggerManage;
import me.wgy.model.User;
import me.wgy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wgy
 * @date 2019-03-21
 */
@RestController
@RequestMapping("/mongodb/users")
public class MongodbController {

  @Autowired
  UserRepository userRepository;

  @LoggerManage(description = "mongodb-创建用户")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "mongodb-创建用户")
  public boolean createUserForMongodb(@RequestParam(value = "name") String name,
      @RequestParam(value = "identity") String identity) {
    // 创建三个User，并验证User总数
    userRepository.save(new User(1, name, identity));
    return Boolean.TRUE;
  }

}
