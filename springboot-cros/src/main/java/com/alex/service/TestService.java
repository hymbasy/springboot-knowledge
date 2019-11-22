package com.alex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TestService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("asyncThreadPoolTaskExecutor")
    //@Async
    public Future<String> asyncMethod() {
        sleep();
        logger.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
        return new AsyncResult<>("hello async");
    }

    public void syncMethod() {
        sleep();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /*int a = 5;
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(a + i);
                if (i == 2) {
                    int b = i/0;
                    System.out.println(1111);
                }
            } catch (Exception e) {
                System.out.println(e);
            }*/
       /* String s = null;
        boolean empty = StringUtils.isEmpty(s);
        System.out.println(empty);*/
        //String str = "91370200163562681G";
        /*String s = "1111111111111111a1";
        Pattern pattern = Pattern.compile("^[A-Z0-9]{18}$");
        Matcher m = pattern.matcher(s);
        if (m.matches()) {
            System.out.println(".......");
        }*/

       /* BigDecimal money = new BigDecimal(1000000000000.00);
        BigDecimal multiply = money.multiply(new BigDecimal(6.88));
        System.out.println(multiply);*/
       List a = null;
        System.out.println(a.size());
    }
}
