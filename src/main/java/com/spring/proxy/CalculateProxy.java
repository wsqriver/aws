package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculateProxy implements InvocationHandler {
    private Object factory;//被代理的类

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        FrontService();
        method.invoke(factory,args);//执行目标类当中的方法
        endService();
        return null;
    }
    public void FrontService() {
        System.out.println("根据您的需求进行市场调研");
    }

    //前置服务
    public void endService() {
        System.out.println("为您提供一条龙的包办服务");
    }
    public Object getProxyInstance() {
        // TODO Auto-generated method stub
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), this);
    }
}
