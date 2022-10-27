package chenjie.leetcode.array;

public class ArraySign {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num < 0) {
                ans *= -1;
            }
            if (num == 0) {
                return 0;
            }
        }
        return ans;
    }
}
