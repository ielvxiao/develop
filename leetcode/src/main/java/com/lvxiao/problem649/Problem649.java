package com.lvxiao.problem649;

/**
 * @author lvxiao <lvxiao@kuaishou.com>
 * Created on 2020-12-11
 */
public class Problem649 {
    public static void main(String[] args) {
        Problem649 problem649 = new Problem649();
        System.out.println(problem649.predictPartyVictory("DDD"));
    }
    public String predictPartyVictory(String senate) {
        if (senate.length() < 3) {
            return senate.charAt(0) == 'R' ? "Radiant" : "Dire";
        }
        StringBuilder sb = new StringBuilder(senate);
        int deleteR = 0, deleteD = 0;
        boolean allR = false, allD = false;
        int index = 0;
        while (sb.length() > 1) {
            char c = sb.charAt(index);
            if (c == 'R') {
                allD = false;
                if (index==0) {
                    allR = true;
                }
                if (index == sb.length() - 1 && allR) {
                    return "Radiant";
                }
                if (deleteR > 0) {
                    sb.deleteCharAt(index);
                    deleteR--;
                    index = index == sb.length() ? 0 : index;
                } else {
                    deleteD++;
                    index = index + 1 == sb.length() ? 0 : index + 1;
                }
            } else {
                allR = false;
                if (index == 0) {
                    allD = true;
                }
                if (index == sb.length() - 1 && allD) {
                    return "Dire";
                }
                if (deleteD > 0) {
                    sb.deleteCharAt(index);
                    deleteD--;
                    index = index == sb.length() ? 0 : index;
                } else {
                    deleteR++;
                    index = index + 1 == sb.length() ? 0 : index + 1;
                }
            }
        }
        return sb.charAt(0) == 'R' ? "Radiant" : "Dire";
    }
}
