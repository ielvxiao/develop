# BeanFactory和ApplicationContext
## 1.BeanFactory
BeanFactory一般被称为IoC容器，是spring的最基本接口，提供Bean配置、管理和创建bean的基本功能。
## 2.ApplicationContext
ApplicationContext被称为应用上下文，是BeanFactory的一个扩展类，提供除了BeanFactory以外的很多额外实用功能。
例如：
- 国际化
- 资源访问，比如访问URL和文件。
- 事件机制。
- 默认初始化所有的Singleton，也可以通过配置取消预初始化。
- 同时加载多个配置文件。
- 以声明式方式启动并创建Spring容器。