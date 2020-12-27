package chenjie.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class FindBestValue {

    public int findBestValue(int[] arr, int target) {
        int right = Arrays.stream(arr).max().getAsInt();
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long sum = sum(arr, mid);
            if (target <= sum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //System.out.printf("%d, %d\n", left - 1, left);
        int leftDistance = Math.abs(target - sum(arr, left - 1));
        int rightDistance = Math.abs(target - sum(arr, left));
        if (leftDistance == rightDistance) {
            return left - 1;
        }
        if (leftDistance < rightDistance) {
            return left - 1;
        }
        return left;
    }

    int sum(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) {
            if (num > target) {
                sum += target;
            } else {
                sum += num;
            }
        }
        return sum;
    }

    @Test
    public void test001() {
        int[] arr = {4, 9, 3};
        assertEquals(3, findBestValue(arr, 10));
    }

    @Test
    public void test002() {
        int[] arr = {1, 3, 5};
        assertEquals(5, findBestValue(arr, 10));
    }

    @Test
    public void test003() {
        int[] arr = {60864, 25176, 27249, 21296, 20204};
        assertEquals(11361, findBestValue(arr, 56803));
    }

}
