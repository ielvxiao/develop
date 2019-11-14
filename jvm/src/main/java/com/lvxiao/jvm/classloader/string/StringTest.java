package com.lvxiao.jvm.classloader.string;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/14 4:59 下午
 */
public class StringTest {


    private static void internTest() {
        String s1 = "Rakesh";
        String s2 = "Rakesh";
        String s3 = "Rakesh".intern();
        String s4 = new String("Rakesh");
        String s5 = new String("Rakesh").intern();

        if (s1 == s2) {
            // string如果不是使用new，则自动intern
            System.out.println("s1 and s2 are same");  // 1.
        }

        if (s1 == s3) {
            System.out.println("s1 and s3 are same");  // 2.
        }

        if (s1 == s4) {
            System.out.println("s1 and s4 are same");  // 3.
        }

        if (s1 == s5) {
            //Intern的效果
            System.out.println("s1 and s5 are same");  // 4.
        }

        String s6 = new String("str") + new String("1");
        s6.intern();    //放入String pool
        String s7 = "str1";

        if (s6 == s7) {
            System.out.println("s6 and s7 are same"); //5
        }

        /*
        这个case不知道为什么？？？？？TODO
         */
        String s8 = new String("a");
        s8.intern();
        String s9 = "a";

        if (s8 == s9) {
            System.out.println("s8 and s9 are same"); //6
        }
    }

    public static void main(String[] args) {
        internTest();
    }
}
