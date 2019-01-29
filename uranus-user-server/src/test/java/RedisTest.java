import lombok.extern.slf4j.Slf4j;
import me.wgy.UserServerApplication;
import me.wgy.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wgy
 * @date 2019-01-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServerApplication.class)
@ActiveProfiles(profiles = "dev")
@Slf4j
public class RedisTest {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @Test
  public void redisTest() {
    // redis存储数据
    String key = "name";
    redisTemplate.opsForValue().set(key, "dayo");
    // 获取数据
    String value = (String) redisTemplate.opsForValue().get(key);
    System.out.println("获取缓存中key为" + key + "的值为：" + value);

    User user = new User();
    user.setId(1);
    user.setName("dayo");
    user.setIdentity("31111111111111");
    String userKey = "dayo";
    redisTemplate.opsForValue().set(userKey, user);
    User newUser = (User) redisTemplate.opsForValue().get(userKey);
    System.out.println("获取缓存中key为" + userKey + "的值为：" + newUser);

  }
}
