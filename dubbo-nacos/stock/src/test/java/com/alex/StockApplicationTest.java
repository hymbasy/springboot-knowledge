package com.alex;

import com.alex.service.StockServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class StockApplicationTest {
    @Autowired
    private StockServiceImpl stockService;

    @Autowired
    private RedisTemplate redisTemplate;

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    //创建线程池  调整队列数 拒绝服务
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize + 1, 10l, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(30));

    @Test
    public void context() {
        System.out.println(stockService.listUser());
    }

    @Test
    public void miaosha() {
        redisTemplate.opsForList().leftPushAll("productlist",1,2,3,4,5,6,7,8,9,10);
        for (int i = 0; i < 30; i++) {
            final long userId = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    Object object = redisTemplate.opsForList().leftPop("productlist");
                    if (object != null) {
                        System.err.println("顾客" + userId + "抢到了" + object + "号商品");
                    } else {
                        System.err.println("顾客" + userId + "没有抢到商品");
                    }
                }
            };
            executor.execute(task);
        }
    }


}
