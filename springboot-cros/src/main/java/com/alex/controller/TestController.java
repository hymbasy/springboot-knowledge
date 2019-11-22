package com.alex.controller;

import com.alex.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;


    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("hello")
    @ResponseBody
    //@CrossOrigin(value = "*")
    public String hello() {
        return "hello";
    }

    @GetMapping("async")
    @ResponseBody
    public String testAsync() throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");
        Future<String> stringFuture = testService.asyncMethod();
        String result = stringFuture.get(60, TimeUnit.SECONDS);
        logger.info("异步方法返回值：{}", result);
        logger.info("异步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return stringFuture.get();
    }

    @GetMapping("sync")
    @ResponseBody
    public void testSync() {
        long start = System.currentTimeMillis();
        logger.info("同步方法开始");
        testService.syncMethod();

        logger.info("同步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

}
