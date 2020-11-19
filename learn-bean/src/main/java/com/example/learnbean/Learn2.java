package com.example.learnbean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.support.GenericApplicationContext;

/**
 * BeanDefinition 注册
 * 通过创建BeanDefinitionBuilder创建BeanDefinition，然后注册成Bean 注册
 * API配置
 */
public class Learn2 {
    public static void main(String[] args) {
        //通过BeanDefinitionBuilder创建BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition("com.example.learnbean.entity.User");
        beanDefinitionBuilder
                .addPropertyValue("name","Jane")
                .addPropertyValue("age",18)
                .addPropertyValue("id",31321);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 创建 BeanFactory 容器
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        // 根据beanDefinition注册成spring bean
        applicationContext.registerBeanDefinition("testBean",beanDefinition);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 根据bean name 查找Bean
        System.out.println(applicationContext.getBean("testBean").toString());
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }
}
