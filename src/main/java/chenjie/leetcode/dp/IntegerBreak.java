package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IntegerBreak {
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(j * dp[n - j], dp[i]);
                dp[i] = Math.max(j * (n - j), dp[i]);
            }

        }
        return dp[n];
    }
    int[] memo;
    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, 0);
        return dfs(n);
    }

    public int dfs(int n) {
        if(n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans,  Math.max(i * (n - i), i * dfs(n - i)));
        }
        memo[n] = ans;
        return ans;
    }

    @Test
    public void test01() {
        Assert.assertEquals(1, integerBreak(2));
    }

    @Test
    public void test02() {
        Assert.assertEquals(36, integerBreak(10));
    }
}
