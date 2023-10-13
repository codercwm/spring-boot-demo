package com.coderxm.exception;

import com.coderxm.constant.Status;
import lombok.Getter;

@Getter
public class JsonException extends BaseException{
    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String msg) {
        super(code, msg);
    }
}
