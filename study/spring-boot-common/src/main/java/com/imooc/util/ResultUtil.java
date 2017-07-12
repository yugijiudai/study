package com.imooc.util;


import com.imooc.enums.ResultEnum;
import com.imooc.vo.ResultVo;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-28
 */
public final class ResultUtil {

    private ResultUtil() {
    }

    public static ResultVo buildSuccess(Object data) {
        return new ResultVo<>(ResultEnum.SUCCESS, data);
    }

    public static ResultVo buildSuccess() {
        return buildSuccess(null);
    }


    public static ResultVo buildError(ResultEnum resultEnum, String msg) {
        return new ResultVo<>(resultEnum, msg);
    }

    public static ResultVo buildError(ResultEnum resultEnum) {
        return new ResultVo<>(resultEnum, resultEnum.getMsg());
    }


}
