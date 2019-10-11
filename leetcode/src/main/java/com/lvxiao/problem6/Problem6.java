package com.lvxiao.problem6;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/11 6:13 下午
 */
public class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int divisor = 2 * (numRows - 1);
        int gap = s.length() / divisor + (s.length() % divisor == 0 ? 0 : 1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < gap; j++) {
                int index = divisor * j + i;
                if (index > s.length() - 1) {
                    break;
                }
                sb.append(s.charAt(index));
                if (i != 0 && i != numRows - 1 && divisor * (j + 1) - i <= s.length() - 1) {
                    sb.append(s.charAt(divisor * (j + 1) - i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        System.out.println(problem6.convert("PAYPALISHIRING", 3));
    }
}
