package com.coderxm.controller;

import com.coderxm.mapper.UserMapper;
import com.coderxm.pojo.User;
import com.coderxm.util.Response;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("list")
    public com.coderxm.pojo.Page list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "2") Integer size,
            String username,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end
    ) {
        PageHelper.startPage(page, size);
        List<User> userList = userMapper.list(username, begin, end);
        Page<User> userPage = (Page<User>) userList;

        com.coderxm.pojo.Page p = new com.coderxm.pojo.Page(userPage.getTotal(), userPage.getResult());

        return p;
    }
}
