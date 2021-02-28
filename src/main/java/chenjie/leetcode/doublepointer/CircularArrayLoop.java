package chenjie.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class CircularArrayLoop {
    //457. 环形数组循环
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int fast = i;
            int slow = i;
            int firsNum = nums[i];
            do {
                fast = findNextIndex(nums, firsNum, fast);
                if (-1 == fast) {
                    continue;
                }
                fast = findNextIndex(nums, firsNum, fast);
                if (fast == -1) {
                    continue;
                }
                slow = findNextIndex(nums, firsNum, slow);
            } while (fast != -1 && slow != -1 && fast != slow);

            if (slow != -1 && fast == slow) {
                return true;
            }
        }
        return false;
    }

    private int findNextIndex(int[] arr, int firstNum, int currentIndex) {
        if (firstNum * arr[currentIndex] < 0) {
            return -1;
        }
        int nextIdx;
        if ((currentIndex + arr[currentIndex]) % arr.length >= 0) {
            nextIdx = (currentIndex + arr[currentIndex]) % arr.length;
        } else {
            nextIdx = (currentIndex + arr[currentIndex]) % arr.length + arr.length;
        }
        if (nextIdx == currentIndex) {
            return -1;
        }
        return nextIdx;
    }

    @Test
    public void test01() {
        int[] arr = {2, -1, 1, 2, 2};
        Assert.assertTrue(circularArrayLoop(arr));
    }

    @Test
    public void test02() {
        int[] arr = {-1, 2};
        Assert.assertFalse(circularArrayLoop(arr));
    }

    @Test
    public void test03() {
        int[] arr = {-2, 1, -1, -2, -2};
        Assert.assertFalse(circularArrayLoop(arr));
    }
}
