package chenjie.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (row == 0 && column == 0) {
            return matrix;
        }
        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
        }

        for (int i = 0 ;i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                    }
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (j < column - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                    }
                    if (i < row - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                }
            }
        }

        return dp;
    }

    @Test
    public void test001() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] res = updateMatrix(matrix);
        for(int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
