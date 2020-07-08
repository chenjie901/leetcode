package chenjie.leetcode.divideandconquer;

import org.junit.Test;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }

        return -1;
    }

    @Test
    public void testSearch() {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch() {
        System.out.println(binarySearch(new int[]{2,3,8,9}, 3));
    }

    public int leftBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return l;
    }

    @Test
    public void test002() {
        System.out.println(leftBound(new int[]{1, 2, 2, 2, 3}, 2));
    }
}
