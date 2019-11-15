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

        String s6 = new String("str") + new String("1"); //创建"str"堆对象，"1"堆对象，"str1"对象.在常量池创建"str"与"1"
        s6.intern();    // 将对象"str1"的引用放入常量池
        String s7 = "str1"; //存在，取"str1"的引用放入常量池

        if (s6 == s7) {
            System.out.println("s6 and s7 are same"); //5
        }

        String s8 = new String("a"); //创建"a"堆对象，与常量池常量
        s8.intern(); //将
        String s9 = "a";

        if (s8 == s9) {
            System.out.println("s8 and s9 are same"); //6
        }
    }

    /*
     判断这个常量是否存在于常量池。
  如果存在
   判断存在内容是引用还是常量，
    如果是引用，
     返回引用地址指向堆空间对象，
    如果是常量，
     直接返回常量池常量
  如果不存在，
   将当前对象引用复制到常量池,并且返回的是当前对象的引用
     */
    private static void interTest2() {
        String first = "Hello"; //创建常量池常量
        String second = "Hello";
        System.out.println("first == second:" + (first == second)); //true 两个都是常量池常量

        String third = new String("Hello"); //创建堆上对象，常量池常量存在
        String fourth = new String("Hello"); //创建堆上对象，常量池常量存在
        System.out.println("third == fourth:" + (third == fourth)); //false 堆上引用
        System.out.println("third == fourth.intern()" + (third == fourth.intern()));    //false 堆上引用和常量池常量
        System.out.println("third.intern() == fourth" + (third.intern() == fourth));    //同上
        System.out.println("third == fourth" + (third == fourth));  //false 堆上引用
        System.out.println("third.intern() == fourth.intern()" + (third.intern() == fourth.intern())); //true
        System.out.println("third.intern() == first" + (third.intern() == first)); // true

        String fifth = new String(new char[]{'H', 'e', 'l', 'l', 'o'}); //创建堆上对象，常量池常量存在
        String sixth = new String(new char[]{'H', 'e', 'l', 'l', 'o'}); //创建堆上对象，常量池常量存在
        System.out.println("fifth == fifth.intern()" + (fifth == fifth.intern())); //false 堆上引用和常量池常量
        System.out.println("sixth == sixth.intern()" + (sixth == sixth.intern()));  //false 堆上引用和常量池常量

        String seven = new String(new char[]{'H', 'e', 'l', 'l', 'o', '2'}); //创建堆上对象与常量池常量
        String eight = new String(new char[]{'H', 'e', 'l', 'l', 'o', '2'}); //创建堆上对象 常量池常量存在
        System.out.println("seven == seven.intern()" + (seven == seven.intern()));  //常量池引用，引用是堆上对象地址
        System.out.println("eight == eight.intern()" + (eight == eight.intern()));  // eight.intern()是seven
        System.out.println("seven == eight.intern()" + (seven == eight.intern()));

    }

    public static void main(String[] args) {
        interTest2();
    }
}
