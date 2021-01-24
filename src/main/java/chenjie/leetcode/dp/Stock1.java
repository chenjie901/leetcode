package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class Stock1 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        //第i天完成j手交易，且持有股票的最大利润
        int[][] havingStock = new int[n][k + 1];
        //第i天完成j手交易，且不持有股票的最大利润
        int[][] notHavingStock = new int[n][k + 1];

        havingStock[0][0] = -prices[0];
        notHavingStock[0][0] = 0;

        for (int i = 1; i <= k; i++) {
            //第0天，完成k > 0手交易，持有股票，是无意义的
            havingStock[0][i] = Integer.MIN_VALUE / 2;
            //第0天，完成k > 0手交易，且不持有股票，最大利润为不
            notHavingStock[0][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            //第i天完成0手交易，最大利润为前一天的和买当前股票的最大值
            havingStock[i][0] = Math.max(havingStock[i - 1][0], -prices[i]);
            //第i天完成0手交易，不持有股票，最大利润为0
            notHavingStock[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                havingStock[i][j] = Math.max(havingStock[i - 1][j], notHavingStock[i - 1][j] - prices[i]);
                notHavingStock[i][j] = Math.max(notHavingStock[i - 1][j], havingStock[i - 1][j - 1] + prices[i]);
                ans = Math.max(ans, notHavingStock[i][j]);
            }
        }
        return ans;
    }

    @Test
    public void test001() {
        int[] prices = {2, 4, 1};
        Assert.assertEquals(2, maxProfit(2, prices));
    }
}
