package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class LongestArithSeqLength {
    public int longestArithSeqLength1(int[] A) {
        Map<String, Integer> dp = new HashMap<>();
        dp.put(String.format("%d_%d", 1, A[1] - A[0]), 2);
        for (int i = 2; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int step = A[i] - A[j];
                String key = String.format("%d_%d", j, step);
                Integer len = dp.get(key);
                if (len == null) {
                    dp.put(String.format("%d_%d", i, step), 2);
                } else {
                    dp.put(String.format("%d_%d", i, step), len + 1);
                }
            }
        }


        return dp.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public int longestArithSeqLength(int[] A) {
        int[][] dp = new int[A.length][20000];
        Arrays.stream(dp).forEach(c -> Arrays.fill(c, 1));
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j] + 10000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff]+ 1);
                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans;
    }



    @Test
    public void test01() {
        int[] arr = {3, 6, 9, 12};
        Assert.assertEquals(4, longestArithSeqLength(arr));
    }
}