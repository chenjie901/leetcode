package chenjie.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

public class CountingSort {

    public void sort(int[] arr) {
        int[] counter = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]]++;
        }
        for (int i = 1; i < arr.length; i++) {
            counter[i] += counter[i - 1];
        }
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[counter[arr[i]] - 1] = arr[i];
            counter[arr[i]] -= 1;
        }
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void test01() {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        sort(arr);
    }
}
