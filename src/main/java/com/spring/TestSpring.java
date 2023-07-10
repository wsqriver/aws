package com.spring;

import com.spring.proxy.CalculateProxy;
import com.spring.service.Calculate;
import com.spring.service.impl.CalculateImpl;
import org.junit.Test;

public class TestSpring {

    @Test
    public  void testProxy(){
        Calculate target=new CalculateImpl();
        CalculateProxy proxy= new CalculateProxy();
        proxy.setFactory(target);
        Calculate proxyInstance = (Calculate)proxy.getProxyInstance();
        proxyInstance.add();

    }
}
