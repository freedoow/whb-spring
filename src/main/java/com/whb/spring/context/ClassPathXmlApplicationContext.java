package com.whb.spring.context;

import com.whb.spring.BeanDefinition;
import com.whb.spring.beans.BeanFactory;
import com.whb.spring.beans.BeansException;
import com.whb.spring.beans.SimpleBeanFactory;
import com.whb.spring.beans.XmlBeanDefinitionReader;
import com.whb.spring.core.ClassPathXmlResource;
import com.whb.spring.core.Resource;

/**
 * @author whb
 * @Description: 解析xml定义bean 步骤：
 * 1、解析 XML 文件中的内容。
 * 2、加载解析的内容，构建 BeanDefinition。
 * 3、读取 BeanDefinition 的配置信息，实例化 Bean，然后把它注入到 BeanFactory 容器中。
 * @Date 2023-03-13
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;

    //context负责整合容器的启动过程，读外部配置，解析Bean定义，创建BeanFactory
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    //context再对外提供一个getBean，底下就是调用的BeanFactory对应的方法
    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
