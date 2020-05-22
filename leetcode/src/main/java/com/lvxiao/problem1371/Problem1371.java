package com.lvxiao.problem1371;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvxiao
 * @date 2020/5/20
 */
public class Problem1371 {
    public static void main(String[] args) {
        System.out.println(new Problem1371().findTheLongestSubstring("varemmeppp"));
    }
    public int findTheLongestSubstring(String s) {
        //收集状态码第一次出现时的index
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        //需要维护的状态码变量
        int status = 0;

        //将-1置为第一次出现0状态码的index
        map.put(0, -1);

        for(int i = 0;i < s.length();i++){
            char now = s.charAt(i);

            if(now == 'a') {
                //00001
                status = status ^ (1);

                map.putIfAbsent(status, i);
            }else if(now == 'e') {
                //00010
                status = status ^ (1 << 1);

                map.putIfAbsent(status, i);
            }else if(now == 'i') {
                //00100
                status = status ^ (1 << 2);

                map.putIfAbsent(status, i);
            }else if(now == 'o') {
                //01000
                status = status ^ (1 << 3);

                map.putIfAbsent(status, i);
            }else if(now == 'u') {
                //10000
                status = status ^ (1 << 4);

                map.putIfAbsent(status, i);
            }

            //如果此时，map中存在这个状态码，证明此时，除去第一个该状态码所在的index，可得出去除map.get(status)这个index后                   i - status所在index这段字符串中所有元音都为0或者为偶数个，那么进行取最大值判断max为多少
            if(map.containsKey(status)){
                max = Math.max(max, i - map.get(status));
            }
        }

        return max;
    }
}
