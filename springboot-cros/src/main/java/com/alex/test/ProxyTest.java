package com.alex.test;

import com.alex.config.CGLIBProxy;
import com.alex.config.JDKDynamicProxy;
import com.alex.service.UserService;
import com.alex.service.impl.UserCGLIBServiceImpl;
import com.alex.service.impl.UserServiceImpl;

public class ProxyTest {

    public static void main(String[] args) {
        System.out.println("jdk动态代理开始");
        UserService userService = new UserServiceImpl();
        //userService.login();
        System.out.println("===================================");
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        UserService userServiceProxy = (UserService) jdkDynamicProxy.newProxy(userService);
        userServiceProxy.login();
        System.out.println("jdk动态代理结束");
        System.out.println("===================================");
        System.out.println("开始使用CGLIB代理*********************");
        UserCGLIBServiceImpl cglibService = new UserCGLIBServiceImpl();
        //cglibService.login();
        System.out.println("-----------------------------------------");
        UserCGLIBServiceImpl cglibProxy = (UserCGLIBServiceImpl)new CGLIBProxy().createProxyInstance(cglibService);
        cglibProxy.login();

    }
}
