package chenjie.leetcode.divideandconquer;

import org.junit.Test;

public class MajorityElement {

    @Test
    public void testMajorityElement() {
        int[] nums = {1,1,3,4,4,3,1,3,3};
        System.out.println(majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    public int countElement(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == num) count++;
        }

        return count;
    }

    public int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi - lo) /2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        System.out.printf("%d,%d --> %d\n", lo, mid, left);
        int right = majorityElementRec(nums, mid + 1, hi);
        System.out.printf("%d,%d --> %d\n", mid+1, hi, right);


        if (left == right) {
            return left;
        }

        int leftCount = countElement(nums, left, lo, hi);
        int rightCount = countElement(nums, right, lo, hi);

        return leftCount > rightCount ? left: right;

    }

}
