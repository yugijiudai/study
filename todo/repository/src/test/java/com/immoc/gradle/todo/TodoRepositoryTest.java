package com.immoc.gradle.todo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-04
 */
public class TodoRepositoryTest {

    private TodoRepository todoRepository = new TodoRepository();


    @Test
    public void saveTest() throws Exception {
        TodoItem item = new TodoItem("item");
        todoRepository.save(item);
        // assertNull(todoRepository.query(item.getName()));
        assertNotNull(todoRepository.query(item.getName()));
    }

}