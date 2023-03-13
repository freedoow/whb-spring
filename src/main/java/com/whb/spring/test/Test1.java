package com.whb.spring.test;

import com.whb.spring.ClassPathXmlApplicationContext;

/**
 * @author whb
 * @Description:
 * @Date 2023-03-13
 */
public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService) ctx.getBean("aservice");
        aService.sayHello();
    }
}
