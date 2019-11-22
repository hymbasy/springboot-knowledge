package com.alex.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 动态代理实现
 */
public class JDKDynamicProxy implements InvocationHandler {
    //
    private Object proxyObj;


    public Object newProxy(Object proxyObj) {
        this.proxyObj = proxyObj;
        return Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), proxyObj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.proxyObj, args);
        after();
        return object;
    }

    public void before() {
        System.out.println("开始执行目标对象之前...");
    }

    public void after() {
        System.out.println("开始执行目标对象之后...");
    }

}
