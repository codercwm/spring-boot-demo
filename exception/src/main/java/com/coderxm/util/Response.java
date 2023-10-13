package com.coderxm.util;

import com.coderxm.constant.Status;
import com.coderxm.exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Integer code;

    private String msg;

    private Object data;

    /**
     * 返回一个自定义响应
     * @param code 状态码
     * @param msg  提示信息
     * @param data 数据
     * @return ApiResponse
     */
    public static Response res(Integer code, String msg, Object data) {
        return new Response(code, msg, data);
    }

    /**
     * 用Status来组装一个响应，并且带数据
     * @param status {@link Status} 状态
     * @param data 数据
     * @return ApiResponse
     */
    public static Response status(Status status, Object data) {
        return res(status.getCode(), status.getMsg(), data);
    }

    /**
     * 用Status来组装一个响应，不带数据
     * @param status {@link Status} 状态
     * @return ApiResponse
     */
    public static Response status(Status status) {
        return status(status, null);
    }

    /**
     * 返回一个带数据的成功相应
     * @param data Object
     * @return Response
     */
    public static Response success(Object data) {
        return status(Status.OK, data);
    }

    /**
     * 返回一个不带数据的成功相应
     * @return Response
     */
    public static Response success() {
        return status(Status.OK);
    }

    /**
     * 返回一个失败且带数据的相应
     * @param t 异常
     * @param data 数据
     * @return Response
     * @param <T> {@link BaseException}
     */
    public static <T extends BaseException> Response fail(T t, Object data) {
        return res(t.getCode(), t.getMsg(), data);
    }

    /**
     * 返回一个失败且不带数据的相应
     * @param t 异常
     * @return Response
     * @param <T> {@link BaseException}
     */
    public static <T extends BaseException> Response fail(T t) {
        return fail(t, null);
    }


}
