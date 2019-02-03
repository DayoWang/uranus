package me.wgy.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.wgy.mapper.UserMapper;
import me.wgy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wgy
 * @date 2019-02-03
 */
@Component
public class Query implements GraphQLQueryResolver {

  @Autowired
  UserMapper userMapper;

  public Iterable<User> findAllUsers() {
    return userMapper.selectAll();
  }
}
