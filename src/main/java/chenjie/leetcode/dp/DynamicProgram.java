package chenjie.leetcode.dp;

import org.junit.Test;

public class DynamicProgram {

    @Test
    public void testLis() {
        int[] arr = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxAns = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
    @Test
    public void testLongestPalindrome () {
        System.out.println(longestPalindrome("a"));
    }

    @Test
    public void testExpand() {
        String s = "abac";
        System.out.println(expandAroundCenter(s, 0, 1));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.toCharArray().length - 1; i++) {
            int tmpMax = 0;
            int len = expandAroundCenter(s, i, i);
            int len1 = expandAroundCenter(s, i, i + 1);
            tmpMax = Math.max(len, len1);
            if (tmpMax > end - start) {
                start = i - (tmpMax - 1) / 2;
                end = i + (tmpMax) / 2 + 1;
            }
        }
        return s.substring(start, end);
    }



    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    private int expandAroundCenter1(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    @Test
    public void testCoinChange() {
        int[] coins = {1, 2, 5};
        int target = 11;

        System.out.println(coinChange(coins, target));
    }



    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChange(coins, amount, memo);

    }

    public int coinChange(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }

        if (memo[amount] != 0) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = coinChange(coins, amount - coins[i], memo);
            if (res >= 0 && res + 1 < min) {
                min = res + 1;
            }

        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;

        return memo[amount];
    }

}
