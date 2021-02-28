package chenjie.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//90. 子集 II
public class SubsetsWithDup {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        backtrace(nums, 0, used, new LinkedList<>());
        return ans;
    }

    private void backtrace(int[] nums, int idx, int[] used, List<Integer> path) {
        ans.add(new LinkedList<>(path));
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtrace(nums, i + 1, used, path);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
