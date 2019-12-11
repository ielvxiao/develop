package com.lvxiao.jvm.classloader.spi;

import java.util.ServiceLoader;

/**
 * 优点：
 * 使用Java SPI机制的优势是实现解耦，使得第三方服务模块的装配控制的逻辑与调用者的业务代码分离，而不是耦合在一起。应用程序可以根据实际业务情况启用框架扩展或替换框架组件。
 *
 * 缺点：
 *
 * 虽然ServiceLoader也算是使用的延迟加载，但是基本只能通过遍历全部获取，也就是接口的实现类全部加载并实例化一遍。如果你并不想用某些实现类，它也被加载并实例化了，这就造成了浪费。获取某个实现类的方式不够灵活，只能通过Iterator形式获取，不能根据某个参数来获取对应的实现类。
 * 多个并发多线程使用ServiceLoader类的实例是不安全的。
 *
 * 作者：分布式系统架构
 * 链接：https://www.jianshu.com/p/46b42f7f593c
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/11 8:50 下午
 */
public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal : animals) {
            animal.shout();
        }
    }
}
