package chenjie.leetcode.backtrack;

import java.util.Arrays;

//494. 目标和
public class FindTargetSumWays {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if (S > sum) {
            return 0;
        }
        if ((S + sum) % 2 != 0) {
            return 0;
        }

        int target = (S + sum) / 2;
        Arrays.sort(nums);
        backtrace(nums, 0, 0, target);
        return ans;
    }

    private void backtrace(int[] nums, int idx, int sum, int target) {
        if (sum == target) {
            ans++;
        }

        if (idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            sum += nums[i];
            backtrace(nums, i + 1, sum, target);
            sum -= nums[i];
        }
    }
}
