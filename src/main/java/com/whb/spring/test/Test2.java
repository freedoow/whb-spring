package com.whb.spring.test;


import com.whb.spring.beans.BeansException;
import com.whb.spring.context.ClassPathXmlApplicationContext;

/**
 * @author whb
 * @Description:
 * @Date 2023-03-13
 */
public class Test2 {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService) ctx.getBean("aservice");
        aService.sayHello();
    }

}
