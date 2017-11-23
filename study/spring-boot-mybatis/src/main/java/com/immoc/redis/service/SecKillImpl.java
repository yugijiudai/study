package com.immoc.redis.service;


import com.immoc.redis.util.JedisLock;
import lombok.extern.log4j.Log4j2;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Log4j2
public class SecKillImpl implements SeckillInterface {

    public static Map<Long, Long> inventory;

    public static Map<Long, AtomicInteger> error;


    @Resource
    private RedissonClient redisson;

    @Resource
    private JedisPool jedisPool;

    static {
        inventory = new ConcurrentHashMap<>();
        inventory.put(10000001L, 500L);
        inventory.put(10000002L, 10000L);
        error = new ConcurrentHashMap<>();
        error.put(10000001L, new AtomicInteger(0));
        error.put(10000002L, new AtomicInteger(0));
    }

    @Override
    public void secKill(Long goodId) {
        RLock lock = null;
        try {
            lock = redisson.getLock("me");
            lock.lock(5, TimeUnit.SECONDS);
            reduceInventory(goodId);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void test(Long goodId) {
        Jedis jedis = jedisPool.getResource();
        JedisLock lock = new JedisLock(jedis, "me", 1000, 3000);
        try {
            lock.acquire();
            reduceInventory(goodId);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.release();
            jedis.close();
        }
    }

    //模拟秒杀操作，姑且认为一个秒杀就是将库存减一，实际情景要复杂的多
    private void reduceInventory(Long goodId) {
        Long count = inventory.get(goodId);
        if (count > 0) {
            // inventory.put(goodId, inventory.get(goodId) - 1);
            inventory.put(goodId, --count);
        }
        else {
            error.get(goodId).incrementAndGet();
        }
    }

}
