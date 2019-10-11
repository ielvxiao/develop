package com.lvxiao.jvm.classloader.jmm;

/**
 * 开启两个线程，即便是flag变为true，①处仍然无法走过，这是因为虽然全局变量更改，但是jmm模型中，线程中的变量都是变量副本
 * 所以①处变量副本并不会随着主内存中的变量更改而更改，如果给flag加volatile关键字，则可以。
 * 注意：如果①中执行打印操作，则此线程中的flag也会更改，这是因为println方法有synchronized关键字。‼️‼️
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/10 10:55 下午
 */
public class ShareMemoVar {
   private  static boolean flag = false;

    private static void setFlag() {
        System.out.println("setFlag begin");
        flag = true;
        System.out.println("setFlag end");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("等待结束");
            /*
            ①
             */
            while (!flag) {
//                System.out.println(flag);
                int a = 0;
            }
            System.out.println("结束");
        }).start();
        Thread.sleep(2000);
        new Thread(()->{
            setFlag();
        }).start();
    }
}
