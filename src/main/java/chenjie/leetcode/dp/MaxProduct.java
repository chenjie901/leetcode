package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        System.arraycopy(nums, 0, dp1, 0, len);
        System.arraycopy(nums, 0, dp2, 0, len);
        for (int i  = 1; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1] * nums[i], Math.max(nums[i], dp2[i - 1] * nums[i]));
            dp2[i] = Math.min(dp1[i - 1] * nums[i], Math.min(nums[i], dp2[i - 1] * nums[i]));
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));
        return Arrays.stream(dp1).max().getAsInt();
    }
    @Test
    public void test001() {
        int[] arr = {-2, 3, -4};
        Assert.assertEquals(24, maxProduct(arr));
    }

    @Test
    public void test002() {
        int[] arr = {2, 3, 4};
        Assert.assertEquals(24, maxProduct(arr));
    }

    @Test
    public void test003() {
        int[] arr = {2, 3, -2, 4};
        Assert.assertEquals(6, maxProduct(arr));
    }
}
