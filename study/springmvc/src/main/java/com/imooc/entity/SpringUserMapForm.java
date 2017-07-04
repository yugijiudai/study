package com.imooc.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-21
 */
@Data
public class SpringUserMapForm {

    private Map<String, SpringUser> users;
}
