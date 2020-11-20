package com.example.learnbean;

import com.example.learnbean.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 构建一个BeanDefinition
 */
public class Learn1 {
    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition("testBean");
        beanDefinitionBuilder
                .addPropertyValue("msg", "hello world")
                .addPropertyValue("describe", "this is a test bean");
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition.toString());

        // 2. 通过 AbstractBeanDefinition的衍生类构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 123)
                .add("name", "Jany")
                .add("age", 18);
        genericBeanDefinition.setPropertyValues(propertyValues);
        System.out.println(genericBeanDefinition.toString());
    }
}
