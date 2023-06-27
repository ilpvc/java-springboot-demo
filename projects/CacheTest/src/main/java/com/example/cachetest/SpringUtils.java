package com.example.cachetest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @date:2023/6/26 15:47
 * @author: ilpvc
 */
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    //根据bean name 获取实例
    // 通过name获取 Bean.
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
    // 通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    // 通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
}
