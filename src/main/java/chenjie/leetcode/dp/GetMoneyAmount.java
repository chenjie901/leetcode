package chenjie.leetcode.dp;

import java.util.Arrays;

public class GetMoneyAmount {
    int[][] memo;
    public int getMoneyAmount(int n) {
        memo = new int[n + 1][n + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return helper(1, n);
    }

    int helper(int low, int high) {
        if (low >= high) {
            return 0;
        }
        if(memo[low][high] != -1) {
            return memo[low][high];
        }
        int min = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int max = Math.max(helper(low, i - 1), helper(i + 1, high)) + i;
            min = Math.min(min, max);
        }
        memo[low][high] = min;
        return min;
    }
}
