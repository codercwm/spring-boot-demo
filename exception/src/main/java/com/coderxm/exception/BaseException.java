package com.coderxm.exception;

import com.coderxm.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
// 如果比较两个对象时需要考虑父类（基类，超类）中的成员，使用@EqualsAndHashCode(callSuper=true)，才能正确比较
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private Integer code;
    private String msg;

    public BaseException(Status status) {
        // 调用父类构造参数
        super(status.getMsg());
        this.code = status.getCode();
        this.msg  = status.getMsg();
    }

    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
