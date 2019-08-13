package com.lvxiao.jvm.classloader.staticandfinal;

/**
 * @author lvxiao
 * @date 2019/8/13
 */
public class TestStaticAndFinal {
    static String staticStr = "sta";
    final String finalStr = "fnal";
    static final String stafinalStr = "fnal";
    private String prString = "pr";
    /**
     * 查看编译后的内容，被声明为final的变量会直接被替换
     *     public String test() {
     *         String a1 = staticStr;
     *         String a2 = "fnal";
     *         String a3 = "fnal";
     *         return a3;
     *     }
     * @return
     */
    public String test() {
        String a1 = staticStr;
        String a2 = finalStr;
        String a3 = stafinalStr;
        String a4 = prString;
        return a3;
    }
    public static void main(String[] args) {
        System.out.println(new TestStaticAndFinal().test());
    }
}
