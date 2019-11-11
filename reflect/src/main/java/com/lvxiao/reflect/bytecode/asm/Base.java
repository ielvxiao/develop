package com.lvxiao.reflect.bytecode.asm;

import java.lang.management.ManagementFactory;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/11 1:51 下午
 */
public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }
    public void process(){
        System.out.println("process");
    }
}
