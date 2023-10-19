package com.coderxm.mapper;

import com.coderxm.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper // 写在mapper接口类中，表示该接口类的实现类对象交给mybatis底层创建，然后交由Spring框架管理
public interface UserMapper {
    public List<User> list(String username, LocalDateTime begin, LocalDateTime end);
}
