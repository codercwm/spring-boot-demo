package com.coderxm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor // 自动生成无参构造
@AllArgsConstructor // 自动生成全参构造
public class User {

    private Integer id;

    private String username;

    private String usernameAlias;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
