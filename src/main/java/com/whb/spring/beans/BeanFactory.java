package com.whb.spring.beans;

import com.whb.spring.BeanDefinition;

/**
 * @author whb
 * @Description:
 * @Date 2023-03-13
 */
public interface BeanFactory {
    //获取一个 Bean
    Object getBean(String beanName) throws BeansException;

    //注册一个 BeanDefinition(registerBeanDefinition)
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
