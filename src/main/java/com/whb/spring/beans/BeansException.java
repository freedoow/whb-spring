package com.whb.spring.beans;

/**
 * @author whb
 * @Description: 异常处理类
 * @Date 2023-03-13
 */
public class BeansException extends Exception {
    public BeansException() {
    }

    public BeansException(String msg) {
        super(msg);
    }
}
