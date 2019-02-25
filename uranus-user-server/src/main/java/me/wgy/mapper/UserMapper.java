package me.wgy.mapper;

import java.util.List;
import me.wgy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author wangguangyuan
 */
@Mapper
public interface UserMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  User selectByName(@Param("name") String name);

  User selectByIdentity(@Param("identity") String identity);

  List<User> selectAll();


}