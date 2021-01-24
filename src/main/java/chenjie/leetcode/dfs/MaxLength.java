package chenjie.leetcode.dfs;

import org.junit.Test;

import java.util.*;

public class MaxLength {

    public int maxLength(List<String> arr) {
        return dfs(arr, 0).size();
    }

    //返回[i, length]最大长度
    private Set<Character> dfs(List<String> arr, int start) {
        if (start == arr.size()) {
            return new HashSet<>();
        }

        Set<Character> maxSet = new HashSet<>();
        int max = 0;
        for (int i = start; i < arr.size(); i++) {
            Set<Character> res = dfs(arr, i + 1);
            String cur = arr.get(start);
            boolean selfCheck = selfCheck(cur);
            if (selfCheck && check(res, cur)) {
                for (char c : arr.get(start).toCharArray()) {
                    res.add(c);
                }
                if (res.size() > max) {
                    maxSet = res;
                    max = maxSet.size();
                }
            } else if (res.size() > max) {
                maxSet = res;
                max = maxSet.size();
            }
        }
        return maxSet;
    }

    private boolean check(Set<Character> choose, String str) {
        for (Character c : str.toCharArray()) {
            if (choose.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean selfCheck(String str) {
        Set<Character> set = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    @Test
    public void test001() {
        List<String> arr = new LinkedList<>(Arrays.asList("yy"));
        System.out.println(maxLength(arr));
    }


}
