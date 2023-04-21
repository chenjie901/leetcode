package chenjie.leetcode.daily;

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
}
