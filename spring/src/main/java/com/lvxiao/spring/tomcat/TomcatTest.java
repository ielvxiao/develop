package com.lvxiao.spring.tomcat;

import lombok.SneakyThrows;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author lvxiao
 * @date 2020/5/15
 */
public class TomcatTest {
    @SneakyThrows
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        StandardContext context = new StandardContext();
        tomcat.start();
        tomcat.getServer().await();
    }
}
