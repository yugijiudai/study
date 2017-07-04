package com.imooc.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-21
 */
@Data
public class SpringUserListForm {

    private List<SpringUser> users;
}
