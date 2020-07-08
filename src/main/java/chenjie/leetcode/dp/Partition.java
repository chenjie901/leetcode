package chenjie.leetcode.dp;

import org.junit.Test;

public class Partition {

    @Test
    public void testCanPatition() {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
    //416
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) { //第i件物品不能放入容量为j的容器中
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];

    }
}
