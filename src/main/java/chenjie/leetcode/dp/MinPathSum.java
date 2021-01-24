package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int colum = grid[0].length;
        int[][] dp = new int[row][colum];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < colum; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1;i < row;i++) {
            for (int j = 1; j < colum; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        for (int i = 0; i < colum; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[row - 1][colum - 1];
    }

    @Test
    public void test001() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Assert.assertEquals(7, minPathSum(grid));
    }
}
