package com.imooc.entity;

import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-21
 */
@Data
public class SpringUserSetForm {

    private Set<SpringUser> users;


    public SpringUserSetForm() {
        users = new LinkedHashSet<>();
        // SpringUser不能覆盖hashCode,不然这里添加会当成同一个对象
        users.add(new SpringUser());
        users.add(new SpringUser());
    }


}
