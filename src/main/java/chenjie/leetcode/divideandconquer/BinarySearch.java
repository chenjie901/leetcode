package chenjie.leetcode.divideandconquer;

import org.junit.Test;

public class BinarySearch {

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    // 落在前有序数组里
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                // 让分支和上面分支一样
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // 要排除掉左边界之前，先看一看左边界可以不可以排除
                if (nums[left] == target) {
                    return true;
                } else {
                    left = left + 1;
                }
            }

        }
        // 后处理，夹逼以后，还要判断一下，是不是 target
        return nums[left] == target;
    }


    @Test
    public void test003() {
        search(new int[]{1, 1, 3, 1}, 3);
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

    public int left(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) /2;
            if (arr[mid] == target) {
                right = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test004() {
        int[] arr = {1, 2, 3,5, 5,8};
        System.out.println(left(arr, 4));
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
