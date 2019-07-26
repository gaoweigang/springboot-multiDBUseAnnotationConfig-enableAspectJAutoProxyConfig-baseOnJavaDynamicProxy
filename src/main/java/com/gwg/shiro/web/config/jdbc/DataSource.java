package com.gwg.shiro.web.config.jdbc;

import java.lang.annotation.*;

/**
 * 1.如果是使用JDK动态代理的话，该注解要写在接口上面
 * 2.如果是使用GGLIB动态代理的话，该注解写在类上面
 * 3.如果使用aspectj静态代理，该注解写在类上面
 * @author gwg
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
