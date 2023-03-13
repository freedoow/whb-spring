package com.whb.spring.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * @author whb
 * @Description: 解析xml资源
 * @Date 2023-03-13
 */
public class ClassPathXmlResource implements Resource {

    Document document;
    Element rootElement;
    Iterator elementIterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        //将配置文件装载进来，生成一个迭代器，可以用于遍历
        try {
            this.document = saxReader.read(xmlPath);
            this.rootElement = document.getRootElement();
            this.elementIterator = this.rootElement.elementIterator();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }

    public Object next() {
        return this.elementIterator.next();
    }
}