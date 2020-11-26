package chenjie.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class CanPartitionKSubSets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = Arrays.stream(nums).sum() / k;
        Arrays.sort(nums);
        return canPartition(nums, new int[k], target, nums.length - 1);
    }

    public boolean canPartition(int[] nums, int[] groups, int target, int idx) {
        //base case
        if (idx == -1) {
            for (int i = 0; i < groups.length; i++) {
                if (groups[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int j = 0; j < groups.length; j++) {
            if (groups[j] + nums[idx] <= target) {
                groups[j] += nums[idx];
                if (canPartition(nums, groups, target, idx - 1)) {
                    return true;
                }
                groups[j] -= nums[idx];
            }

        }
        return false;
    }

    @Test
    public void test001() {
        int[] nums = {1, 2, 1, 1, 1};
        Assert.assertTrue(canPartitionKSubsets(nums, 2));
    }

    @Test
    public void test002() {
        int[] nums = {1, 2, 1, 1, 2};
        Assert.assertFalse(canPartitionKSubsets(nums, 2));
    }
}
