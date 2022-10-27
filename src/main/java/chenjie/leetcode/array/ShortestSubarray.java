package chenjie.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

// 862
public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> d = new LinkedList<>();
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = n +1;
        for (int i = 0; i <= n; i++) {
            while (!d.isEmpty() && preSum[i] - preSum[d.peekFirst()] >= k ) {
                ans = Math.min(ans, i - d.peekFirst());
                d.pollFirst();
            }
            while (!d.isEmpty() && preSum[i] <= preSum[d.peekLast()]) {
                d.pollLast();
            }
            d.offerLast(i);
        }
        return ans < n + 1 ? ans : -1;
    }
}
