package chenjie.leetcode.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums, new int[nums.length], new LinkedList<>());
        return ans;
    }

    private void backtrace(int[] nums, int[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 ) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = 1;
            backtrace(nums, visited, path);
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test001() {
        int[] arr = {3,3,0,3};
        List<List<Integer>> ans = permuteUnique(arr);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
