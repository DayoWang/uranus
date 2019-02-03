package me.wgy.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.wgy.model.User;
import org.springframework.stereotype.Component;

/**
 * @author wgy
 * @date 2019-02-03
 */
@Component
public class Mutation implements GraphQLMutationResolver {

  public User newUser(String name, String identity) {
    User user = new User();
    user.setName(name);
    user.setIdentity(identity);
    return user;
  }
}
