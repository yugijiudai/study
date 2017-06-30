package com.immoc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {


    @Resource
    private MockMvc mvc;


    @Test
    public void girlListTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/listGirls")).andExpect(MockMvcResultMatchers.status().isOk());
                // .andExpect(MockMvcResultMatchers.content().string("abc"));
    }

}