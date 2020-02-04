package com.lvxiao.problem79;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/2/4 3:07 下午
 */
public class Problem79 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用深度遍历
     */
    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row == -1 || col == -1 || row == board.length || col == board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        board[row][col] += 256;
        if (dfs(board, word, row + 1, col, index + 1) || dfs(board, word, row - 1, col, index + 1)
                || dfs(board, word, row, col + 1, index + 1) || dfs(board, word, row, col - 1, index + 1)) {
            return true;
        }
        board[row][col] -= 256;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem79().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
    }
}
