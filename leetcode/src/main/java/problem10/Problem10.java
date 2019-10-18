package problem10;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/16 2:54 下午
 */
public class Problem10 {

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[sLen+1][pLen+1];
        //默认空字符串匹配空字符串
        memory[0][0] = true;
        //如果出现"x*x*...."类似情况其实是可以匹配的
        for (int i = 2; i <= pLen; i+=2) {
            memory[0][i] = memory[0][i - 2] && p.charAt(i - 1) == '*';
        }
        for(int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    memory[i][j] = memory[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        memory[i][j] = memory[i][j - 2];
                    } else {
                        memory[i][j] = memory[i - 1][j] || memory[i - 1][j - 1] || memory[i][j - 2];
                    }
                }
            }
        }
        return memory[sLen][pLen];
    }

    public static void main(String[] args) {
        System.out.println(new Problem10().isMatch("aaa", "ab*ac*a"));
        System.out.println();
    }
}
