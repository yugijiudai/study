package com.immoc.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-11
 */
@Data
@NoArgsConstructor
public class Demo{

    private Long id;

    private String name;

    public Demo(String name) {
        this.name = name;
    }

}
