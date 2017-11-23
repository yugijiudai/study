package com.immoc.redis.service;


public interface SeckillInterface {

    // @CacheLock(lockedPrefix = "TEST_PREFIX")
    // void secKill(@LockedObject Long goodId);


    void secKill(Long goodId);

    void test(Long goodId);
}
