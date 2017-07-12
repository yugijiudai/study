package com.immoc.exHandle;

import com.immoc.exception.GirlException;
import com.imooc.enums.ResultEnum;
import com.imooc.util.ResultUtil;
import com.imooc.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>1.新建一个class</p>
 * <p>2.在class上添加注解@ControllerAdvice</p>
 * <p>3.在class中添加一个方法</p>
 * <p>4.在方法上添加@ExceptionHandler拦截对应的异常信息</p>
 * <p>5.如果返回的是view -- 方法的返回值是ModelAndView</p>
 * <p>6.如果返回的是String或者json数据,那么需要在方法上添加 @ResponseBody注解</p>
 *
 * @author yugi
 * @apiNote
 * @since 2017-06-28
 */
@ControllerAdvice
@Log4j2
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo handleException(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.buildError(ResultEnum.stateOf(girlException.getCode()), e.getMessage());
        }
        // ModelAndView mv = new ModelAndView();
        // mv.setViewName(viewName);
        log.error("【系统异常】{}", e.getMessage());
        return ResultUtil.buildError(ResultEnum.UNKNOWN_ERROR);
    }
}
