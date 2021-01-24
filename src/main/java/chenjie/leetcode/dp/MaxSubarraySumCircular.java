package chenjie.leetcode.dp;

import java.util.Arrays;

public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int sum = Arrays.stream(A).sum();
        return Math.max(maxSubArray(A), sum - minSubArray(A));
    }

    public int maxSubArray(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int minSubArray(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < dp.length - 1; i++) {
            dp[i] = Math.min(arr[i], dp[i - 1] + arr[i]);
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
