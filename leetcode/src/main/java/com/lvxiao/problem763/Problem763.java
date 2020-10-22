package com.lvxiao.problem763;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lvxiao
 * @date 2020/10/22
 */
public class Problem763 {
    public static void main(String[] args) {
        new Problem763().partitionLabelsOfficial("qiejxqfnqceocmy");//13,1,1
    }

    /*

    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> partitionLabelsOfficial(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }


    /**
     * 两个方法其实思路一样，只不过这个方法慢在了{@link String#lastIndexOf(int)}
     * 因为这个方法还是从后向前遍历，所以如果像官方解法一样使用一个26位的数组保存最大位置，就非常好
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        List<Integer> res = new LinkedList<>();
        int i = 0;
        while (i < len) {
            //最好是一个字母一组
            char c = s.charAt(i);
            int lastIndex = s.lastIndexOf(c);
            //刚好符合
            if (lastIndex != i) {
                for (int j = i + 1; j < lastIndex; j++) {
                    int newIndex;
                    if ((newIndex = s.lastIndexOf(s.charAt(j))) > lastIndex) {
                        lastIndex = newIndex;
                    }
                }
            }
            res.add(lastIndex - i + 1);
            i = lastIndex + 1;
        }

        return res;
    }
}
