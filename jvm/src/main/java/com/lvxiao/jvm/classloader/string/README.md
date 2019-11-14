# String
java中使用特别多的一个类
## 字符串拼接效率问题
参考 http://www.pellegrino.link/2015/08/22/string-concatenation-with-java-8.html
通过javap -c命令可以看出来class文件里边对+=操作也是转换成stringbuilder处理的，
但是问题就是每次循环都要new一次StringBuilder，所以效率不如直接在外层使用StringBuilder。
但是不会出现字符串常量池有很多的情况。
### 我们可以通过基准测试来对比各种情况下的性能，可参考`StringConcatenationBenchmark`