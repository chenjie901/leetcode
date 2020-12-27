package chenjie.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearch {
    public int leftBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
//            int mid = left + (right - left ) / 2;
            if (arr[mid] == target) {
                right = mid - 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int rightBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (target >= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public int leftBound1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int rightBound1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1)/2;
            if (target >= arr[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void testLeftBound() {
        int[] arr = {1, 3, 3, 7, 8};
//        assertEquals(1, leftBound(arr, 3));
//        assertEquals(0, leftBound(arr, 0));
//        assertEquals(5, leftBound(arr, 9));
        assertEquals(3, leftBound(arr, 4));
    }

    @Test
    public void testLeftBound1() {
        int[] arr = {1, 3, 3, 7, 8};
        assertEquals(1, leftBound1(arr, 3));
        assertEquals(0, leftBound1(arr, 0));
        assertEquals(4, leftBound1(arr, 9));
        assertEquals(3, leftBound1(arr, 4));
    }

    @Test
    public void testRightBound() {
        int[] arr = {1, 3, 3, 5, 8};
        assertEquals(2, rightBound(arr, 3));
        assertEquals(-1, rightBound(arr, 0));
        assertEquals(4, rightBound(arr, 9));
        assertEquals(2, rightBound(arr, 4));
    }

    @Test
    public void testRightBound1() {
        int[] arr = {1, 3, 3, 5, 8};
        assertEquals(2, rightBound1(arr, 3));
        assertEquals(0, rightBound1(arr, 0));
        assertEquals(4, rightBound1(arr, 9));
        assertEquals(2, rightBound1(arr, 4));
    }

}
