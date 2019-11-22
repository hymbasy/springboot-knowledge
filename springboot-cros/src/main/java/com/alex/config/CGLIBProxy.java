package com.alex.config;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {

    private Object targetObject;


    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try {
            System.out.println("前置处理开始");
            result = methodProxy.invoke(targetObject, objects);
            System.out.println("后置处理开始");
        } catch (Exception e) {
            System.out.println("异常处理");
        } finally {
            System.out.println("调用结束");
        }
        return result;
    }
}
