总结下Starter的工作原理:
- Spring Boot在启动时扫描项目所依赖的JAR包，寻找包含spring.factories文件的JAR包
- 根据spring.factories配置加载AutoConfigure类
- 根据 @Conditional 注解的条件，进行自动配置并将Bean注入Spring Context