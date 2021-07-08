package com.tsn.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author tsn77
 * @Date 2021/7/8 15:03
 * @Version 1.0
 */
@Data
public class Result implements Serializable {
    private String code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        Result m = new Result();
        m.setCode("200");
        m.setData(data);
        m.setMsg("操作成功");
        return m;
    }

    public static Result success(String mess, Object data) {
        Result m = new Result();
        m.setCode("200");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }

    public static Result failure(String mess) {
        Result m = new Result();
        m.setCode("500");
        m.setData(null);
        m.setMsg(mess);
        return m;
    }

    public static Result failure(String mess, Object data) {
        Result m = new Result();
        m.setCode("500");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }

    public static Result failure(String code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}



