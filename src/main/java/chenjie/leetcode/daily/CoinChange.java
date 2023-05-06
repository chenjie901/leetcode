package chenjie.leetcode.daily;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.stream(coins).forEach(c -> dp[c] = 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin > 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
