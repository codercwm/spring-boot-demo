package com.coderxm.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import com.coderxm.mapper.UserMapper;
import com.coderxm.pojo.User;
import com.coderxm.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/select")
    public Response select() {
        List<User> userList = userMapper.select();
        return Response.success(userList);
    }

    @GetMapping("/get-by-id")
    public Response getById(@RequestParam(required = true, name = "id") Integer id) {
        User user = userMapper.getById(id);
        return Response.success(user);
    }

    @PostMapping("/create")
    public Response create(@RequestBody User reqUser) {
        User user = new User();
        user.setUsername(reqUser.getUsername());
        user.setPassword(reqUser.getPassword());
        userMapper.insert(user);
        return Response.success(user);
    }

    @PutMapping("/update")
    public Response update(@RequestBody User reqUser) {
        if (reqUser.getId() == null || reqUser.getId() < 1) {
            return Response.error("id不能为空");
        }
        User user = new User();
        user.setId(reqUser.getId());
        user.setUsername(reqUser.getUsername());
        user.setPassword(reqUser.getPassword());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
        return Response.success(user);
    }

    @GetMapping("/search")
    public Response search(String keyword, String createTimeStart, String createTimeEnd) {
        List<User> userList = userMapper.search(keyword, createTimeStart, createTimeEnd);
        return Response.success(userList);
    }
}
