package com.coderxm.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.coderxm.annotation.AopLogAnnotation;
import com.coderxm.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    // @AopLogAnnotation("测试日志test方法") // 用注解的方式记录日志
    public Response test(@RequestParam(required = false, name = "hello") String hello) {
        if (StrUtil.isBlank(hello)) {
            hello = "World";
        }

        return Response.success(Dict.create().set("hello", hello));
    }

    @PostMapping("/testJson")
    // @AopLogAnnotation("测试日志testJson方法") // 用注解的方式记录日志
    public Response testJson(@RequestBody Map<String, Object> map) {
        final String jsonStr = JSONUtil.toJsonStr(map);
        return Response.success(map);
    }
}
