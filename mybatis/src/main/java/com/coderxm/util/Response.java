package com.coderxm.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    /**
     * 1成功, 0失败
     */
    private Integer code;

    private String msg;

    private Object data;

    public static Response success(Object data){
        return new Response(1, "success", data);
    }

    public static Response success(){
        return new Response(1, "success", null);
    }

    public static Response error(String msg){
        return new Response(0, msg, null);
    }
}
