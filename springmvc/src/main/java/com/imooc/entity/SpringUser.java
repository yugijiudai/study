package com.imooc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-21
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
// @Data
public class SpringUser {

    private String name;

    private Integer age;

    private ContactInfo contactInfo;

    public static void main(String[] args) {

    }


}
