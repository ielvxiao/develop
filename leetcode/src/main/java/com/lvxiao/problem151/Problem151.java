package com.lvxiao.problem151;

/**
 * 151. Reverse Words in a String
 *
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 22:44
 */
public class Problem151 {
    /**
     * 151. 翻转字符串里的单词 Medium
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] chas = s.toCharArray();
        reverseString(chas, 0, chas.length - 1);
        int begin = 0;
        String streamStr = String.valueOf(chas);
        String[] arr = streamStr.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char[] tempChas = arr[i].toCharArray();
            reverseString(tempChas, 0, tempChas.length - 1);
            sb.append(String.valueOf(tempChas));
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private void reverseString(char[] chas, int from, int to) {
        while (from < to) {
            char temp = chas[from];
            chas[from++] = chas[to];
            chas[to--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem151().reverseWords("  hello world!  "));
    }
}
