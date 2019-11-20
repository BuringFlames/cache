//package com.hwy.cache;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//
//public class SpringUtil implements ApplicationContextAware{
//
//    private static ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        if(applicationContext != null) {
//            SpringUtil.applicationContext = applicationContext;
//        }
//    }
//
//    private static ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    public static <T> T getBeanByClazz(Class<T> clazz) {
//        return getApplicationContext().getBean(clazz);
//    }
//
//    public static Object getBeanByName(String name) {
//        return getApplicationContext().getBean(name);
//    }
//
//    public static <T> T getBean(String name, Class<T> clazz) {
//        return getApplicationContext().getBean(name, clazz);
//    }
//}
