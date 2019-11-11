# 反射知识学习

# java字节码技术
> 参考网址：https://tech.meituan.com/2019/09/05/java-bytecode-enhancement.html

## ASM与Javassist
ASM在`指令层`操作字节码，代码晦涩难懂。。。。不易使用
<br>Javassist在`源代码层`操作字节码
<br>以上两种技术都是在已编译好的class文件进行修改。
## Instrument
上一章重点介绍了两种不同类型的字节码操作框架，且都利用它们实现了较为粗糙的AOP。其实，为了方便大家理解字节码增强技术，在上文中我们避重就轻将ASM实现AOP的过程分为了两个main方法：第一个是利用MyClassVisitor对已编译好的class文件进行修改，第二个是new对象并调用。这期间并不涉及到JVM运行时对类的重加载，而是在第一个main方法中，通过ASM对已编译类的字节码进行替换，在第二个main方法中，直接使用已替换好的新类信息。另外在Javassist的实现中，我们也只加载了一次Base类，也不涉及到运行时重加载类。
<br>instrument是JVM提供的一个可以修改已加载类的类库，专门为Java语言编写的插桩服务提供支持。

