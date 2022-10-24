package  chenjie.leetcode.everyday;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

// 915
public class PartitionDisjoint {
    public int partitionDisjoint(int[] nums) {
        int curMax = nums[0];
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n  - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.min(rightMax[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (curMax <= rightMax[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }


    @Test
    public void test01() {
        int[] arrs = { 5, 0, 3, 8, 6 };
        Assert.assertEquals(3, partitionDisjoint(arrs));
    }

    @Test
    public void test02() {
        int[] arrs = { 1,1,1,0,6,12};
        Assert.assertEquals(4, partitionDisjoint(arrs));
    }
}
