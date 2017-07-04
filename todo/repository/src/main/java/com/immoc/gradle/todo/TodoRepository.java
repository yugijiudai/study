package com.immoc.gradle.todo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-04
 */
public class TodoRepository {

    private static Map<String, TodoItem> items = new HashMap<>();

    public void save(TodoItem todoItem) {
        items.put(todoItem.getName(), todoItem);
    }

    public TodoItem query(String name) {
        return items.get(name);
    }


}
