package me.wgy.repository;

import me.wgy.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wgy
 * @date 2019-03-21
 */
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

  User findByName(String name);
}
