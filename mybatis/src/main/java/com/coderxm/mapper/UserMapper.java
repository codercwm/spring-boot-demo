package com.coderxm.mapper;

import com.coderxm.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper // 写在mapper接口类中，表示该接口类的实现类对象交给mybatis底层创建，然后交由Spring框架管理
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> select();

    /**
     * 根据id获取一条数据
     * @param id Integer
     * @return User
     */
    @Results({
            // 使表字段映射到不同名的pojo类属性中
            // 把username字段赋值给pojo类的usernameAlias属性
            @Result(column = "username", property = "usernameAlias"),
    })
    @Select("SELECT * FROM user WHERE id = #{id} LIMIT 1")
    public User getById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") // 表示获取自增键的值并赋值给id属性
    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    public void insert(User user);

/*
    @Update("UPDATE user SET username = #{username}, password = #{password}, update_time = #{updateTime} WHERE id = #{id}")
    public void update(User user);
*/

    @Delete("DELETE FROM user WHERE id = #{id}")
    public void delete(Integer id);

    public List<User> search(String keyword, String createTimeStart, String createTimeEnd);

    public void update(User user);
}
