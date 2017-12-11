package com.immoc.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Demo {

    private Long id;

    private String name;

    private Date createTime;

    public Demo(String name) {
        this.name = name;
    }

}
