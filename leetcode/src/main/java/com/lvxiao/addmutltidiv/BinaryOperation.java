package com.lvxiao.addmutltidiv;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/5 11:20 下午
 */
public class BinaryOperation {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE-(Integer.MAX_VALUE>>1)));
        System.out.println(binaryAdd(-6, -15));
        System.out.println(binaryMulti(5, 6));
        System.out.println(binaryMulti2(5, 6));
        System.out.println(binaryDiv(6, 3));
    }

    private static int binaryAdd(int a, int b) {// 正负数都包含在里面，不用分开处理
        int s = a ^ b;// 不考虑进位的和
        int jw = a & b;// 进位

        // 下面是 s + (jw<<1) 的计算
        while (jw != 0) {
            int jw_temp = s & (jw << 1);// 保存s + (jw<<1)的进位
            s = s ^ (jw << 1);// 保存s + (jw<<1)的和，不包含进位
            jw = jw_temp;// 赋值之后，还是计算s+(jw<<1)，依旧是计算：进位以及不进位的和，当进位为0时，不进位的和就是最终的计算结果
        }
        return s;
    }

    private static int binaryMulti(int a, int b) {// 计算a*b
        if (a == 0 || b == 0)
            return 0;

        int res = 0;
        int base = a;
        while (b != 0) {
            if ((b & 1) != 0)
                res = binaryAdd(res, base);
            b >>= 1;
            base <<= 1;
        }

        return res;
    }
    private static int binaryMulti2(int a, int b) {// 计算a*b
        if (a == 0 || b == 0)
            return 0;

        if(b>a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int res = 0;
        int shift = 0;
        while(b!=0) {
            if((b&1)!=0) {
                res += (a<<shift);
            }
            shift += 1;
            b >>= 1;
        }
        return res;
    }

    private static int binaryDiv(int a, int b) throws Exception {// 计算a/b
        if (b == 0)
            throw new Exception("分母不能为0");

        boolean flag = false;
        if ((a ^ b) < 0)
            flag = true;// 表示a,b异号；
        a = a >= 0 ? a : -a;
        b = b >= 0 ? b : -b;

        int res = 0;
        int aux = 0;//依次获取a的最高位
        int mask = 0x40_00_00_00;// 用来依次获取分母的最高位bit
        while (mask != 0) {
            /*
            按位依次左移，比如6(110)/3(11)，110左移的时候，一位一位来。
             */
            aux = (aux << 1) | ((a & mask) == 0 ? 0 : 1);// 这里注意处理，尤其是后半部分表达式，很容易写成aux
            if (aux >= b) {
                res = (res << 1) | 1;
                aux = binaryAdd(aux, -b);
            } else {
                res = (res << 1) | 0;
            }
            mask >>= 1;

        }

        return flag ? -res : res;
    }
}
