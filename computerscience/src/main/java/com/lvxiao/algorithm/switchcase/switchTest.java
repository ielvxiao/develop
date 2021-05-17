package com.lvxiao.algorithm.switchcase;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2021-05-16
 */
public class switchTest {
    private int switchTest(int a) {
        switch (a) {
            case 0:
                return 0;
            case 1:
                return a * 10;
            case 2:
                return a * 20;
            case 3:
                return a * 30;
            case 4:
                return a * 40;
        }
        return a;
    }
}
