package  chenjie.leetcode.everyday;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

// 915
public class PartitionDisjoint {
    public int partitionDisjoint(int[] nums) {
        int curMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (curMax <= minValue(nums, i + 1)) {
                return i + 1;
            }
        }
        return -1;
    }

    int minValue(int[] nums, int i) {
        int min = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
            min = Math.min(min, nums[j]);
        }
        return min;
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
