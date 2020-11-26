package chenjie.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int j = 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        //滑动窗口， fast-catchup
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum < nums[i]) {
                curSum = nums[i];
                j = i;
            }
            if (curSum > maxSum) {
                start = j;
                end = i;
                maxSum = curSum;
            }
        }

        System.out.printf("start : %d, end : %d\n", start, end);
        return maxSum;
    }

    @Test
    public void test001() {
        int[] arr = {1, -5, 3, 4};
        int res = maxSubArray(arr);
        Assert.assertEquals(7, res);
    }
}
