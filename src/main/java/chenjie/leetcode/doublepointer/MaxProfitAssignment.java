package chenjie.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxProfitAssignment {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        Arrays.sort(worker);
        int len = difficulty.length;
        Integer[] index = new Integer[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> difficulty[a] - difficulty[b]);
//        System.out.println(Arrays.toString(index));
        for (int i = worker.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = len - 1; j >= 0; j--) {

                if (difficulty[index[j]] <= worker[i]) {
                    max = Math.max(max, profit[j]);
                }

            }
            ans += max;
        }
        return ans;
    }

    @Test
    public void test001() {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        Assert.assertEquals(324, maxProfitAssignment(difficulty, profit, worker));
    }
}
