package com.immoc.exHandle;

import com.immoc.enums.ResultEnum;
import com.immoc.exception.GirlException;
import com.immoc.util.ResultUtil;
import com.immoc.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
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
        log.error("【系统异常】{}", e.getMessage());
        return ResultUtil.buildError(ResultEnum.UNKNOWN_ERROR);
    }
}
