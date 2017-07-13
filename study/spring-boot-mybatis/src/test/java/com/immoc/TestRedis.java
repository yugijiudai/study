package com.immoc;

import com.immoc.pojo.Demo;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class TestRedis {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }



    @Test
    public void testObj() throws Exception {
        Demo demo = new Demo("demo name");
        ValueOperations<String, Demo> operations = redisTemplate.opsForValue();
        operations.set("com.neox", demo);
        operations.set("com.neo.f", demo, 60, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        }
        else {
            System.out.println("exists is false");
        }
    }
}
