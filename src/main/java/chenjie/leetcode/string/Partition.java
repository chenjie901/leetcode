package chenjie.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 难度
 * 中等
 *
 * 358
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 关注
 * 反馈
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Partition {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new LinkedList<>());
        return res;
    }

    private boolean isEchoStr(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public void backtrack(String s, int idx, Deque<String> path) {
        if (idx == s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int len = 1; len <= s.length() - idx; len++) {
            String candidate = s.substring(idx, idx + len);
            if (!isEchoStr(candidate)) {
                continue;
            }
            path.add(candidate);
            backtrack(s, idx + len, path);
            path.removeLast();
        }
    }

    @Test
    public void test001() {
        String str = "a";
        List<List<String>> res = partition(str);

        res.forEach(l -> System.out.println(l));

        System.out.println(isEchoStr(""));

    }
}
