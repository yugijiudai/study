package com.immoc.vo;

import com.immoc.enums.ResultEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yugi
 * @apiNote http请求返回的最外层对象
 * @since 2017-06-28
 */
@Data
@NoArgsConstructor
public class ResultVo<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体类容
     */
    private T data;


    public ResultVo(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }


    public ResultVo(ResultEnum resultEnum, String msg) {
        this.code = resultEnum.getCode();
        this.msg = msg;
    }



}
