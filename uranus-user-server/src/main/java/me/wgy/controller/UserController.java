package me.wgy.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.wgy.log.LoggerManage;
import me.wgy.model.User;
import me.wgy.service.UserService;
import me.wgy.view.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wgy
 * @date 2018/11/18
 */
@RestController
@RefreshScope
@RequestMapping("/users")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
public class UserController {

  @Autowired
  UserService userService;

  @Value("${user.message}")
  String message;

  @LoggerManage(description = "创建用户")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "创建用户")
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
  @ApiOperation(value = "根据姓名查询用户")
  public User queryByName(@RequestParam(value = "name") String name) {
    return userService.queryByName(name);
  }

  @LoggerManage(description = "根据证件号查询用户")
  @RequestMapping(value = "/query/identity", method = RequestMethod.GET)
  @ApiOperation(value = "根据证件号查询用户")
  public User queryByIdentity(@RequestParam(value = "identity") String identity) {
    return userService.queryByIdentity(identity);
  }

  @LoggerManage(description = "分页获取所有用户")
  @RequestMapping(value = "/query/users", method = RequestMethod.GET)
  @ApiOperation(value = "分页获取所有用户")
  public Pagination<User> queryAll(
      @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
    return userService.queryAllByPage(pageNum, pageSize);
  }

  @LoggerManage(description = "获取消息配置")
  @SentinelResource(value = "message", blockHandler = "exceptionHandler", fallback = "messageFallback")
  @RequestMapping(value = "/message", method = RequestMethod.GET)
  @ApiOperation(value = "获取消息配置")
  public String message() {
    return message;
  }

  /**
   * Fallback 函数，函数签名与原函数一致.
   */
  public String messageFallback() {
    return String.format("Message Fallback");
  }

  /**
   * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
   */
  public String exceptionHandler(BlockException ex) {
    // Do some log here.
    ex.printStackTrace();
    return "Message, exceptionHandler ";
  }
}
