package chenjie.leetcode.dp;

import java.util.Arrays;

public class FindLengthOfLCIS {
    /**
     * 1. 子问题，以i结尾的最长子序列
     * 2. 第1步解决后，可以解决原问题
     * 3. dp[i]刻画子问题
     * 4. 以i结尾的最长子序列，需遍历前面所有的值
     * 5. 原问题解决，dp中对长的
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
