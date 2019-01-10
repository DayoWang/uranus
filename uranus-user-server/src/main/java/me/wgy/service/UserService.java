package me.wgy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.wgy.log.LoggerManage;
import me.wgy.mapper.UserMapper;
import me.wgy.model.User;
import me.wgy.view.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @author wgy
 * @date 2018/11/21
 */
@Service
@RefreshScope
public class UserService {

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

  @LoggerManage(description = "service queryAll")
  public Pagination<User> queryAllByPage(Integer pageNum, Integer pageSize) {
    PageInfo pageInfo = PageHelper.startPage(pageNum, pageSize)
        .doSelectPageInfo(() -> userMapper.selectAll());
    Pagination<User> pagination = new Pagination(pageNum, pageSize, pageInfo.getTotal(),
        pageInfo.getList());
    return pagination;
  }
}
