package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class NumTrees {
    public int numTrees(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dfs(i - 1) * dfs(n - i);
        }
        return ans;
    }

    @Test
    public void test01() {
        Assert.assertEquals(5, numTrees(3));
    }
}
