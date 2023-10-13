package com.coderxm.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "appinfo")
public class AppinfoProperty {
    private String a;
    private String b;
    private String c;
}
