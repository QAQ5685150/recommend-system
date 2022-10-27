package com.linxx.recommend.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 类名:SpringContextUtils
 * 描述:spring上下文工具类
 * 姓名:南风
 * 日期:2021-12-03 10:03
 **/
@Component
public class springContextUtils implements ApplicationContextAware {
    public static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        springContextUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name,Class<T> clazz){
        return applicationContext.getBean(name,clazz);
    }

    public static boolean containsBean(String name){
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name){
        return applicationContext.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name){
        return applicationContext.getType(name);
    }
}
