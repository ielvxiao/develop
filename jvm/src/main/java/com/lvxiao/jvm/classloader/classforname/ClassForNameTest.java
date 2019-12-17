package com.lvxiao.jvm.classloader.classforname;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/12/17 4:24 下午
 */
public class ClassForNameTest {

    private static String className = "com.lvxiao.jvm.classloader.classforname.DomainTest";

    /**
     * 加载类并初始化该类
     */
    public static void classForName() {
        try {
            Class c=  Class.forName(className);
//            DomainTest domainTest = (DomainTest) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载类，不会触发初始化
     */
    public static void classLoader()  {
        Class c= null;
        try {
            c = ClassLoader.getSystemClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            Object o = c.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
    public static void main(String[] args) {
        classForName();
    }
}
