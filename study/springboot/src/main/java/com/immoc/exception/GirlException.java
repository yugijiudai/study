package com.immoc.exception;

import com.immoc.enums.ResultEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-28
 */
@Data
@NoArgsConstructor
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
