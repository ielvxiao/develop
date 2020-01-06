package com.lvxiao.jvm.classloader.jmm;

/**
 * 开启两个线程，即便是flag变为true，①处仍然无法走过，这是因为虽然全局变量更改，但是jmm模型中，线程中的变量都是变量副本
 * 所以①处变量副本并不会随着主内存中的变量更改而更改，如果给flag加volatile关键字，则可以。
 * 注意：如果①中执行打印操作，则此线程中的flag也会更改，这是因为println方法有synchronized关键字。‼️‼️
 *
 * 这个变量副本和ThreadLocal的变量副本不同，JMM中的变量副本意思是运行时，会保存一个变量副本。因为不会实时同主存进行同步，所以副本一直是老的
 * 而如果一旦与主存进行同步，或者该线程执行结束，则变量值就会刷入主存
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
