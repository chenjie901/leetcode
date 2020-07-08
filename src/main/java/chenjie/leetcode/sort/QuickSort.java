package chenjie.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void testQuickSort() {
        int[] arr = new int[]{3,1,5,2};
        findKthNum(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void findKthNum() {
        int[] arr = new int[]{3,1,5,2};
        int n = findKthNum(arr, 2);
        System.out.println(n);
    }

    public int findKthNum(int[] arr, int k) {
        return findKthNum(arr, 0, arr.length - 1, k);
    }


    public int findKthNum(int[] arr, int p, int r, int i) {
        if (p == r) {
            return arr[p];
        }

        int q = partition(arr, p, r);
        //计算元素的个数
        int k = q - p + 1;

        if (k == i) {
            return arr[q];
        } else if (i < k) {
            return findKthNum(arr, p, q - 1, i);
        } else {
            return findKthNum(arr, q + 1, r, i - k);
        }
    }

    public void findKthNum(int[] arr) {
        findKthNum(arr, 0, arr.length - 1);
    }

    public void findKthNum(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            findKthNum(arr, p, q - 1);
            findKthNum(arr, q + 1, r);
        }
    }

    public int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, r);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
