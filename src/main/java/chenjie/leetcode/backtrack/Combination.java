package chenjie.leetcode.backtrack;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    List<List<Integer>> output = new LinkedList<>();

//    @Before
//    public void cleanOutput() {
//        output.clear();
//    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, 0, target, new LinkedList<>());
        return output;
    }

    public void backtrace(int[] candidates, int index, int ramain, List<Integer> res) {
        if (ramain == 0) {
            output.add(new LinkedList<>(res));
        }

        for (int i = index; i < candidates.length; i++) {
            if (ramain - candidates[i] < 0) {
                return;
            }
            res.add(candidates[i]);
            backtrace(candidates, i, ramain - candidates[i], res);
            res.remove(res.size() - 1);
        }
    }

    @Test
    public void testCombinationSum() {
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> res = combinationSum(candidates, 7);
        res.stream().forEach(r -> System.out.println(r));
    }

    @Test
    public void testCombine() {
        List<List<Integer>> res = combine(3, 3);
        res.stream().forEach(r -> System.out.println(r));
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrace1(n, 1, k, new LinkedList<>());
        return output;
    }

    public void backtrace1(int n, int index, int k, Deque<Integer> res) {
        if (res.size() == k) {
            output.add(new LinkedList<>(res));
            return;
        }

        for (int i = index; i <= n; i++) {
            if (res.size() + 1 > k) {
                return;
            }
            res.addLast(i);
            backtrace1(n, i + 1, k, res);
            res.removeLast();
        }
    }

    @Test
    public void testSubSets() {
        int[] nums = {1, 2};

//        List<List<Integer>> res = subsets(nums);
//
//        res.stream().forEach(System.out::println);
        backtrack2(nums, 0, 2, new LinkedList<>());
        output.stream().forEach(System.out::println);

    }

    //78
    public List<List<Integer>> subsets(int[] nums) {
        for (int level = 0; level <= nums.length; level++) {
            backtrack2(nums, 0, level, new LinkedList<>());
        }
        return output;
    }

    public void backtrack2(int[] nums, int index, int level, Deque<Integer> res) {
        if (res.size() == level) {
            output.add(new LinkedList<>(res));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (res.size() + 1 > level) {
                return;
            }
            res.addLast(nums[i]);
            backtrack2(nums, i + 1, level, res);
            res.removeLast();
        }
    }

    @Test
    public void testSubStr() {
        String s = "123456";
        System.out.println(s.substring(1, 3));
    }

    @Test
    public void testRestoreIpAddrs() {
        String s = "0000";
        List<String> res = new LinkedList<>();
        backtrack3(s, 0, 0, new LinkedList<>(), res);
        res.stream().forEach(System.out::println);

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        backtrack3(s, 0, 0, new LinkedList<>(), res);
        return res;
    }


    public void backtrack3(String s, int index, int split, Deque<String> path, List<String> res) {


        if (index == s.length() && split == 4) {
            res.add(String.join(".", path));
            return;
        }

        for (int j = 1; j < 4; j++) {
            if (s.length() - index < 4 - split || s.length() - index > 3 * (4 - split)) {
                return;
            }

            int nextBegin = index + j;
            if (nextBegin > s.length()) {
                return;
            }

            String num = s.substring(index, nextBegin);
            if (num.length() > 1 && num.startsWith("0")) {
                return;
            }
            int next = Integer.valueOf(num);
            //no hope
            if (next > 255) {
                return;
            }

            path.addLast(next + "");
            backtrack3(s, nextBegin, split + 1, path, res);
            path.removeLast();
        }
    }
}
