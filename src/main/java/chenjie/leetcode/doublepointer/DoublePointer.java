package chenjie.leetcode.doublepointer;

import org.junit.Test;

import java.util.Arrays;

public class DoublePointer {

    @Test
    public void testTwoSum() {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
