package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dpfist = new int[len][len];
        int[][] dpSec = new int[len][len];

        for (int i = 0; i < len; i++) {
            dpfist[i][i] = piles[i];
            dpSec[i][i] = 0;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int left = piles[i] + dpSec[i + 1][j];
                int right = piles[j] + dpSec[i][j - 1];
                if (left > right) {
                    dpSec[i][j] = dpfist[i + 1][j];
                    dpfist[i][j] = left;
                } else {
                    dpSec[i][j] = dpfist[i][j - 1];
                    dpfist[i][j] = right;
                }
            }
        }

        return dpfist[0][len - 1] > dpSec[0][len - 1];
    }

    private void print(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[1].length; j++) {
                System.out.printf("(%d,%d)\t", dp[i][j][0], dp[i][j][1]);
            }
            System.out.println();
        }
    }


    @Test
    public void test001() {
        int[] piles = {5, 3, 5, 4};
        Assert.assertTrue(stoneGame(piles));
    }
}
