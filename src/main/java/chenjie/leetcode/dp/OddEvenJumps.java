package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OddEvenJumps {
    int[][] cache;
    int ans = 0;

    public int oddEvenJumps(int[] A) {
        cache = new int[A.length][2];
        int len = A.length;

        for (int i = 0; i < len; i++) {
            int max = A[i];
            int min = A[i];
            int maxIdx = i;
            int minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (A[j] >= max) {
                    max = A[j];
                    maxIdx = j;
                }
                if (A[j] <= min) {
                    min = A[j];
                    minIdx = j;
                }
            }

            if (maxIdx > i) {
                cache[i][1] = maxIdx;
            } else {
                cache[i][1] = -1;
            }
            if (minIdx > i) {
                cache[i][0] = minIdx;
            } else {
                cache[i][0] = -1;
            }
        }
        int[] odd = new int[len];
        int[] even = new int[len];
        for (int i = 0; i < len; i++) {
            odd[i] = cache[i][0];
            even[i] = cache[i][1];
        }
        System.out.println(Arrays.toString(odd));
        System.out.println(Arrays.toString(even));

        for (int i = 0; i< len; i++) {
            if (dp(A, i, 0) || dp(A, i, 1)) {
                System.out.println("can jump from " + i);
                ans++;
            }
        }

        return ans;
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dp(int[] arr, int idx, int type) {
        if (idx == arr.length - 1) {
            return true;
        }

        if (type == 0 && cache[idx][1] !=  -1) {
            if (dp(arr, cache[idx][1], 1)) {
                return true;
            }
        }

        if (type == 1 && cache[idx][0] != -1) {
            if (dp(arr, cache[idx][0], 0)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test001() {
        int[] arr = {10,13,12,14,15};

        int[] a = {3, 4};
        System.out.println(binarySearch(a, 0, 1, 8));
    }

}
