package com.coderxm.controller;

import cn.hutool.core.lang.Dict;
import com.coderxm.property.ValueProperty;
import com.coderxm.property.AppinfoProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    @Autowired
    private ValueProperty valueProperty;

    @Autowired
    private AppinfoProperty appinfoProperty;

    @GetMapping("/property")
    public Dict property() {
        return Dict.create().set("valueProperty", valueProperty).set("appinfoProperty", appinfoProperty);
        /*

        {
            "valueProperty": {
                "port": "8080",
                "contextPath": "/demo",
                "envActive": "test",
                "env": "test",
                "artifactId": "properties",
                "version": "0.0.1-SNAPSHOT",
                "a": "测试环境-aaaaaaaa",
                "b": "测试环境-bbbbbbbbbbb",
                "c": "测试环境-cccccccccccc"
            },
            "appinfoProperty": {
                "a": "测试环境-aaaaaaaa",
                "b": "测试环境-bbbbbbbbbbb",
                "c": "测试环境-cccccccccccc"
            }
        }

         */
    }
}
