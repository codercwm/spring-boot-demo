package com.coderxm.exception;

import com.coderxm.constant.Status;
import lombok.Getter;

@Getter
public class PageException extends BaseException{
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String msg) {
        super(code, msg);
    }
}
