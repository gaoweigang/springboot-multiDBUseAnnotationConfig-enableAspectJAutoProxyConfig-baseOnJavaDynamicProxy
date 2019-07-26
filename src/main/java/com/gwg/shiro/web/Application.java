package com.gwg.shiro.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Transactional;

/**
 * 启用Spring代理功能，该功能默认是开启的，我们还是可以做一些特定配置。
 * 在这里使用的是Cglib生成代理对象，默认使用的是Spring AOP生成代理对象
 * 如果使用Cglib来生成代理对象，需要指定需要指定编织时间，在这里使用静态织入，即编译时织入
 * 如果使用maven来构建项目，主要在maven中配置即可
 * @EnableAspectJAutoProxy(proxyTargetClass = false) 优先尝试使用标准的基于Java接口的代理，如果不能使用，则使用CGLIB
 *
 *
 * @EnableAspectJAutoProxy(proxyTargetClass = true) 创建基于子类(CGLIB)的代理
 */
//@EnableAspectJAutoProxy(proxyTargetClass = false)//在Springboot中，AOP默认是开启的，具体可以看该注解配置
//因为我是在DataSourceConfig中自己配置的数据源，因此在此排查SpringBoot自动配置数据源
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, AopAutoConfiguration.class})
@MapperScan("com.gwg.shiro.web.mapper")
public class Application {



    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\class");  //该设置用于输出cglib动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");   //该设置用于输出jdk动态代理产生的类，输出路径为当前项目下面
        SpringApplication.run(Application.class, args);
    }
}
