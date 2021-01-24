package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CanCross {

    Set<Integer>[] memo;

    public boolean canCross(int[] stones) {
        int len = stones.length;
        memo = new Set[len];
        for (int i = 0; i < len; i++) {
            memo[i] = new HashSet<>();
        }
        int step = stones[len - 1];
        for (int i = 0; i < len - 1; i++) {
            if (dfs(stones, len - 1, step - stones[i])) {
                return true;
            }
        }
        return false;
    }

    //走到i位置，可以走多少部过来
    private boolean dfs(int[] stones, int i, int step) {
        if (step <= 0) {
            return false;
        }
//        System.out.printf("at:%d-->step:%d\n", i, step);
        if (i == 1 && stones[i] == 1 && step == 1) {
            return true;
        }

        if(memo[i].contains(step)) {
            return true;
        }

        for (int k = i - 1; k > 0; k--) {
            int tmpStep = stones[i] - stones[k];
            if (tmpStep == step) {
                if (dfs(stones, k, step - 1) ) {
                    memo[k].add(i);
                    return true;
                }
                if (dfs(stones, k, step + 1)) {
                    memo[k].add(step + 1);
                    return true;
                }
                if ( dfs(stones, k, step)) {
                    memo[k].add(step);
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test001() {
        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};
        Assert.assertTrue(canCross(arr));
    }

    @Test
    public void test002() {
        int[] arr = {0, 21};
        Assert.assertFalse(canCross(arr));
    }

    @Test
    public void test003() {
        int[] arr = {0, 2, 4};
        Assert.assertTrue(canCross(arr));
    }

    @Test
    public void test004() {
//        int[] arr = {0, 2};
//        Assert.assertFalse(canCross(arr));
        System.out.println(2L << 31 - 1);
        System.out.println(Integer.MAX_VALUE);
    }
}
