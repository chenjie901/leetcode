package chenjie.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int left = -1;
        for (int right = 0; right < nums.length; ) {
            if (left == right) {
                left = right;
                right++;
            } else if (nums[right] == 1) {
                while (right < nums.length && nums[right] == 1) {
                    right++;
                }
            } else {
                left = right;
            }
            ans = Math.max(ans, right - left - 1);
        }
        return ans;
    }

    @Test
    public void test01() {
        int[] arr = {1, 0};
        Assert.assertEquals(1, findMaxConsecutiveOnes(arr));
    }

    @Test
    public void test02() {
        int[] arr = {0};
        Assert.assertEquals(0, findMaxConsecutiveOnes(arr));
    }
}
