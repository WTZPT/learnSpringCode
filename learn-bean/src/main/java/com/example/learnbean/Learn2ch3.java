package com.example.learnbean;

import com.example.learnbean.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * BeanDefinition 注册
 * Java注解配置
 */
// 3. 通过 @Import 来进行导入
@Import(Learn2ch3.Config.class)
public class Learn2ch3 {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(Learn2ch3.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 按照类型依赖查找
        System.out.println(applicationContext.getBeansOfType(User.class));
        System.out.println(applicationContext.getBeansOfType(Config.class));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    // 2. 通过 @Component 方式
    @Component// 定义当前类作为 Spring Bean（组件）
    public class Config{
        // 1. 通过 @Bean 方式定义
        @Bean
        public User user(){
            User user = new User();
            user.setAge(18);
            user.setName("Jany");
            user.setId(123123);
            return user;
        }
    }
}
