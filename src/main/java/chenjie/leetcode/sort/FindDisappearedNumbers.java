package chenjie.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] tmp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]] += 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
