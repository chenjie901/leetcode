package chenjie.leetcode.dp;

import org.junit.Test;

public class NumTilings {

    public int numTilings(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        if (N == 3) {
            return 5;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= N; i++) {
            dp[i] = 1 +  dp[i - 2] + 2 + dp[i - 3] + 5;
        }
        return dp[N];
    }

    @Test
    public void test001() {
        System.out.println(numTilings(4));
    }
}
