package com.sunhaibo.handle;

import com.sunhaibo.domain.Result;
import com.sunhaibo.enums.ResultEnum;
import com.sunhaibo.exception.GirlException;
import com.sunhaibo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private  final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
          logger.error("[Girl异常] {}" , e.getMessage());
            logger.error("[Girl异常详情] 如下{}" , e);

            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());

        }else if (e instanceof NullPointerException){
            logger.error("[空指针异常]{}",e.getMessage());
            logger.error("[空指针异常详情] 如下{}",e);
            return ResultUtil.error(ResultEnum.NULL_POINT.getCode(),ResultEnum.NULL_POINT.getMsg());
        }


        else {
            logger.error("[系统异常] {}" , e.getClass()+":"+ e.getMessage());
            logger.error("[系统异常详情} 如下{}",e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(),ResultEnum.UNKONW_ERROR.getMsg());
        }
    }
}
