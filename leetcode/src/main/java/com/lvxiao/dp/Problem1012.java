package com.lvxiao.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @date 2020/5/25
 */
public class Problem1012 {
    public int numDupDigitsAtMostN(int N) {
        return N - dp(N);
    }
    /**
     * 找到不重复的数字
     *
     * @param n
     * @return
     */
    public int dp(int n) {
        int total = 0;
        int[] used = new int[10];
        //1、找到位数
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        int k = digits.size();//位数K

        //2、首位为0的情况
        for (int i = k - 1; i >= 1; i--) {
            total += 9 * A(9, i-1);//首位为0，第一个可选的为9项目，剩下的就是在第一位以外的9个数字中任选i-1个填充，题目说小于10^9，不需要考虑大于9位
        }

        //3、首位不为0的情况
        //倒序，从头找，
        for (int i=k-1;i>=0;i--){
            int num = digits.get(i);//获得特定位的数
            //对于选中的num位，以后的数字都要小于它，
            // 比如4325选中了4，那么这个位置的数字必然小于等于4，那么有0123可选，但是由于首位不能为0，因此若为首位可选项少一个
            for (int j=(i==k-1?1:0);j<num;j++){
                //此时j表示用来判断是否要使用的数字,如果被使用过，则不考虑这个数字（这个被使用是说前面的数字，针对i的那个）
                if (used[j] != 0){
                    continue;
                }
                //这个比较微妙，我们注意到外层有一个j的循环，其实这个是对于i这个位置的值，可以选择那些，然后下面的A其实是对再下一位的选择
                //比如4325，当前i==2，表示选中了3，那么对于3这个位置，j可以选择012，那么可以知道j循环会进行3次
                //然后对于25这两个后面的位置，10-(4-2)=8,A(8,2),刚好，因为前面2个位置被选择了，只剩下8个数字，选2个排序
                //本来i==2这个位置，应该是A(9,3)，但是由于要小于num，则使用j来加多次的A(8,2)即可，这个很微妙
                total+=A(10-(k-i),i);
            }
            used[num]++;
            if (used[num] >1){
                //表示前面的数字有重复，比如3325，执行完后33确认，那么比3300大比3325小的数字不用再考虑了（因为我们是倒序的，i从最高位开始）
                break;
            }

            //如果到了最后一位并且不重复，不会进入j的那个循环
            if (i==0){
                total = total+1;
            }
        }
        return total;
    }
    public int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int A(int m, int n) {
        return fact(m) / fact(m - n);
    }
}
