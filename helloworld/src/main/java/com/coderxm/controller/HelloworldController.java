package com.coderxm.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController是一个组合注解，它包含了@Controller和@ResponseBody两个注解的功能，用@RestController标记的类表示这是一个RESTful风格的控制器，它可以处理HTTP请求并返回JSON格式的响应。 @RestController注解在处理请求时，会自动将方法的返回值转换为JSON格式的响应体，并返回给客户端。
public class HelloworldController {

    @GetMapping("/hello") // 创建一个路由hello，处理http get请求
    public String hello(@RequestParam(required = false, name = "hello") String hello) { // 接受非必须请求参数name，赋值给hello参数
        if (StrUtil.isBlank(hello)) {
            // 判断是否为空，如果为空就给默认值
            hello = "World";
        }
        // 拼接字符串并返回
        return StrUtil.format("Hello {}!!", hello);
    }
}
