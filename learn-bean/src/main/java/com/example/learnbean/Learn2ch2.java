package com.example.learnbean;

import com.example.learnbean.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;

/**
 * BeanDefinition 注册
 * Java API配置
 * 通过创建GenericBeanDefinition创建BeanDefinition，然后注册成Bean
 */
public class Learn2ch2 {
    public static void main(String[] args) {
        //创建 GenericBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 123)
                .add("name", "Jany")
                .add("age", 18);
        genericBeanDefinition.setPropertyValues(propertyValues);

        // 创建 BeanFactory 容器
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        // 注册上面创建的genericBeanDefinition
        applicationContext.registerBeanDefinition("testBean", genericBeanDefinition);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 根据bean name 查找Bean
        System.out.println(applicationContext.getBean("testBean"));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }
}
