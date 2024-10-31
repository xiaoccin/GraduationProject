package org.xiaocc.commonmodule.entity;

import lombok.Data;

@Data
public class Result {

    public static Result success(Object data){
        Result result = new Result();
        result.setData(data);
        result.success = true;
        result.message = "successful";
        result.code = 200;
        return result;
    }

    public static Result fail(String message){
        Result result = new Result();
        result.setData(null);
        result.success = false;
        result.message = message;
        result.code = 500;
        return result;
    }


    String message;

    int code;

    boolean success;

    Object data;


}
