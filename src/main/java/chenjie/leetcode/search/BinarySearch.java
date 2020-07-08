package chenjie.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {

    @Test
    public void testBinarySearch1() {
        int[] arr = new int[]{1, 3, 5, 7, 8};
        Assert.assertEquals("fail to find", 3, binarySearch01(arr, 7));
        Assert.assertEquals("faild to find", -1, binarySearch01(arr, 9));
    }

    public int binarySearch01(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    @Test
    public void testBinarySearch2() {
        int[] arr = new int[]{1, 3, 3, 7, 8};
        Assert.assertEquals("fail to find", 1, leftBoundBinarySearch(arr, 3));
        Assert.assertEquals("faild to find", -1, leftBoundBinarySearch(arr, 9));
        Assert.assertEquals("faild to find", -1, leftBoundBinarySearch(arr, -1));
    }

    public int leftBoundBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == arr.length) {
            return -1;
        }

        return arr[right] == target ? right : -1;

    }

    public int leftBoundBinarySearch02(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left == arr.length) {
            return -1;
        }

        if (right == -1) {
            return -1;
        }
        return right;
    }

    @Test
    public void testBinarySearch3() {
        int[] arr = new int[]{1, 3, 3, 7, 8};
        Assert.assertEquals("fail to find", -1, right_bound(arr, 9));
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    @Test
    public void sort() {
        Integer[] arr = {4, 1, 8, 2, 6};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
