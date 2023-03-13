package com.whb.spring.beans;

import com.whb.spring.BeanDefinition;
import com.whb.spring.core.Resource;
import org.dom4j.Element;

/**
 * @author whb
 * @Description: xml资源转化为bean
 * @Date 2023-03-13
 */
public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 根据xml解析装载Bean
     *
     * @param resource 解析资源
     */
    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
