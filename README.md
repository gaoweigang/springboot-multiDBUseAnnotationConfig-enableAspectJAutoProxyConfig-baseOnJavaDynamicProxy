Spring AOP 介绍
　　AOP的介绍可以查看 Spring Boot实践——AOP实现

　　与AspectJ的静态代理不同，Spring AOP使用的动态代理，所谓的动态代理就是说AOP框架不会去修改字节码，而是在内存中临时为方法生成一个AOP对象，这个AOP对象包含了目标对象的全部方法，并且在特定的切点做了增强处理，并回调原对象的方法。

　　Spring AOP中的动态代理主要有两种方式，JDK动态代理和CGLIB动态代理。JDK动态代理通过反射来接收被代理的类，并且要求被代理的类必须实现一个接口。JDK动态代理的核心是InvocationHandler接口和Proxy类。

　　如果目标类没有实现接口，那么Spring AOP会选择使用CGLIB来动态代理目标类。CGLIB（Code Generation Library），是一个代码生成的类库，是利用asm开源包，可以在运行时动态的生成某个类的子类。注意，CGLIB是通过继承的方式做的动态代理，因此如果某个类被标记为final，那么它是无法使用CGLIB做动态代理的。

　　这里有注意的几点如下：

从Spring 3.2以后不再将CGLIB放在项目的classpath下，而是将CGLIB类打包放在spring-core下面的org.springframework中。这个就意味着基于CGLIB的动态代理与JDK的动态代理在支持“just works”就一样了。
在Spring 4.0中，因为CGLIB代理实例是通过Objenesis创建的，所以代理对象的构造器不再有两次调用。
在 Spring Boot 2.0 中，Spring Boot现在默认使用CGLIB动态代理(基于类的动态代理), 包括AOP. 如果需要基于接口的动态代理(JDK基于接口的动态代理) , 需要设置spring.aop.proxy-target-class属性为false。

参考：https://www.cnblogs.com/onlymate/p/9630788.html