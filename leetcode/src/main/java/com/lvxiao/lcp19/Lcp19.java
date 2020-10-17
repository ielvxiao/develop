package com.lvxiao.lcp19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lvxiao
 * @date 2020/10/1
 */
public class Lcp19 {
    public static void main(String[] args) {
        new Lcp19().commonChars(new String[]{"bella", "label", "roller"});
    }

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int len = A.length;
        if(len==0) return res;
        int[] arr = new int[26];
        for(int i=0;i<A[0].length();i++){
            arr[A[0].charAt(i)-'a']++;
        }
        for(int i=1;i<len;i++){
            int[] tmp = new int[26];
            for(int j=0;j<A[i].length();j++){
                tmp[A[i].charAt(j)-'a']++;
            }
            for(int j=0;j<26;j++){
                arr[j]=Math.min(arr[j],tmp[j]);
            }
        }
        for(int j=0;j<26;j++){
            if(arr[j]>0){
                for(int i=0;i<arr[j];i++){
                    res.add(String.valueOf((char)('a'+j)));
                }
            }
        }
        return res;
    }

    public int minimumOperations(String leaves) {
        int len = leaves.length();
        int y = 0;
        for (int i = 0; i < len; i++) {
            if (leaves.charAt(i) == 'y') {
                y++;
            }
        }
        //滑动窗口从第二个元素开始
        int red = Integer.MAX_VALUE;
        for (int i = leaves.indexOf('y'); i < len - y; i++) {
            if (red == 0) {
                return 0;
                //i>1的时候不用重新遍历，只用前后两个节点即可
            } else if (i > leaves.indexOf('y')) {
                int count = red;
                if (leaves.charAt(i - 1) == 'r') {
                    count--;
                } else {
                    count++;
                }
                if (leaves.charAt(i + y - 1) == 'r') {
                    count++;
                } else {
                    count--;
                }
                red = Math.min(count, red);
                continue;
            }

            int count = 0;
            for (int j = i; j < i + y; j++) {
                if (leaves.charAt(j) == 'r') {
                    count++;
                }
            }
            red = Math.min(count, red);
        }
        return red;
    }

}
