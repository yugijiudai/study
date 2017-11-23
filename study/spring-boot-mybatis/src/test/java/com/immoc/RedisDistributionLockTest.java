package com.immoc;

import com.immoc.redis.service.SecKillImpl;
import com.immoc.redis.service.SeckillInterface;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhonghaowen
 * @apiNote
 * @since 2017-11-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class RedisDistributionLockTest {


    @Resource
    private SeckillInterface secKillImpl;


    private static Long commidityId1 = 10000001L;

    private static Long commidityId2 = 10000002L;

    @Test
    public void test() throws InterruptedException {
        secKillImpl.secKill(commidityId1);
        // System.out.println(client);
    }


    @Test
    public void testSecKill() {
        int threadCount = 5000;
        int splitPoint = 5000;
        CountDownLatch endCount = new CountDownLatch(threadCount);
        CountDownLatch beginCount = new CountDownLatch(1);
        // ExecutorService exe = Executors.newCachedThreadPool();
        ExecutorService exe = Executors.newFixedThreadPool(6);
        for (int i = 0; i < splitPoint; i++) {
            doTask(endCount, beginCount, exe, commidityId1);
        }
        // for (int i = 0; i < splitPoint; i++) {
        //     doTask(endCount, beginCount, exe, commidityId2);
        // }
        long startTime = System.currentTimeMillis();
        //主线程释放开始信号量，并等待结束信号量
        beginCount.countDown();
        try {
            //主线程等待结束信号量
            endCount.await();
            //观察秒杀结果是否正确
            System.out.println("商品1剩余:" + SecKillImpl.inventory.get(commidityId1));
            // System.out.println("商品2剩余:" + SecKillImpl.inventory.get(commidityId2));
            System.out.println("秒杀失败情况:" + SecKillImpl.error);
            System.out.println("total cost:" + (System.currentTimeMillis() - startTime));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doTask(CountDownLatch endCount, CountDownLatch beginCount, ExecutorService exe, Long id) {
        exe.submit(() -> {
            try {
                //等待在一个信号量上，挂起
                beginCount.await();
                secKillImpl.test(id);
                endCount.countDown();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


}