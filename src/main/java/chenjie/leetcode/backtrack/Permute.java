package chenjie.leetcode.backtrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Permute {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums, new LinkedList<>());
        return ans;
    }

    private void backtrace(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new LinkedList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrace(nums, path);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test001() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = permute(arr);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }
}
