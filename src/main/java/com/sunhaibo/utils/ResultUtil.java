package com.sunhaibo.utils;

import com.sunhaibo.domain.Result;
import com.sunhaibo.enums.ResultEnum;

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public  static  Result success(){
        return success(null);

    }

    public  static  Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
