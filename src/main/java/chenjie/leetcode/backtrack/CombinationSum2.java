package chenjie.leetcode.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, new int[candidates.length], new LinkedList<>());
        return ans;
    }

    private void backtrace(int[] candidates, int target, int idx, int[] visited, List<Integer> path) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new LinkedList<>(path));
            return;
            for (int i = idx; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1] == 0) {
                    continue;
                }
                path.add(candidates[i]);
                visited[i] = 1;
                backtrace(candidates, target - candidates[i], i + 1, visited, path);
                path.remove(path.size() - 1);
                visited[i] = 0;
            }
        }
    }

}
