package chenjie.leetcode.dp;

import org.junit.Test;

public class Stock {
    @Test
    public void testMaxProfit() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    //最多1次交易
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    @Test
    public void testMaxProfit2() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(prices));
    }
    //没有交易限制
    public int maxProfit2(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        dp[0][1] = -prices[0];
        dp[0][0] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];

    }

    @Test
    public void testMaxProfit3() {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit3(prices));
    }


    public int maxProfit3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][3][2];

        for (int k = 0; k <= 2; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][2][0];
    }

    @Test
    public void testMaxProfit4() {
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println(maxProfit4(2, prices));
    }

    public int maxProfit4(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][k + 1][2];

        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }
}
