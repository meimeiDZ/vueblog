package com.mmdz.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MMDZ
 * @description: TODO 统一返回的结果封装
 * @date 2021/5/5 23:06
 */
@Data
public class Result implements Serializable {

    private Integer code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        return success(200, "操作成功!", data);
    }

    public static Result success(String mess, Object data) {
        return success(200, mess, data);
    }

    public static Result success(Integer code, String mess, Object data) {
        Result m = new Result();
        m.setCode(code);
        m.setData(data);
        m.setMsg(mess);
        return m;
    }

    public static Result error(String mess) {
        return error(-1, mess, null);
    }

    public static Result error(String mess, Object data) {
        return error(-1, mess, data);
    }

    public static Result error(Integer code, String mess, Object data) {
        Result m = new Result();
        m.setCode(code);
        m.setMsg(mess);
        m.setData(data);
        return m;
    }
}

