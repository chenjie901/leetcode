package chenjie.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class OddEvenJumps {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (a, b) -> A[a] == A[b] ? a - b : A[a] - A[b]);
        System.out.println(Arrays.toString(arr));
        int[] sin = order(arr);
        System.out.println(Arrays.toString(sin));
        Arrays.sort(arr, (a, b) -> A[a] == A[b] ? a - b : A[b] - A[a]);
        System.out.println(Arrays.toString(arr));
        int[] dou = order(arr);
        System.out.println(Arrays.toString(dou));
        int[][] dp = new int[n][2];
        dp[n - 1][0] = 1;
        dp[n - 1][1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (sin[i] != -1 && dp[sin[i]][1] == 1) dp[i][0] = 1;
            if (dou[i] != -1 && dp[dou[i]][0] == 1) dp[i][1] = 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == 1) count++;
        }
        return count;
    }

    int[] order(Integer[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(arr[i]);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

    @Test
    public void test001() {
        int[] arr = {10,13,12,14,15};

        oddEvenJumps(arr);
    }

}
