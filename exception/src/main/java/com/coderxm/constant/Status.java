package com.coderxm.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    OK(200, "操作成功"), SERVER_ERROR(500, "抱歉，出现异常");

    private Integer code;

    private String msg;


}
