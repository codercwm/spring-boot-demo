package com.coderxm.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ValueProperty {
    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${spring.profiles.active}")
    private String envActive;

    @Value("${env}")
    private String env;

    @Value("${artifact-id}")
    private String artifactId;

    @Value("${version}")
    private String version;

    @Value("${appinfo.a}")
    private String a;

    @Value("${appinfo.b}")
    private String b;

    @Value("${appinfo.c}")
    private String c;
}
