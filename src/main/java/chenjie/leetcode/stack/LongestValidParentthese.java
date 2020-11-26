package chenjie.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentthese {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    //前一个不匹配结束的地方
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }



    @Test
    public void test1() {
        String s = ")))";
        LongestValidParentthese longestValidParentthese = new LongestValidParentthese();
        int res = longestValidParentthese.longestValidParentheses(s);
        Assert.assertEquals(0, res);
    }

    @Test
    public void test2() {
        String s = "((())))";
        LongestValidParentthese longestValidParentthese = new LongestValidParentthese();
        int res = longestValidParentthese.longestValidParentheses(s);
        Assert.assertEquals(6, res);
    }

    @Test
    public void test3() {
        String s = "())(())";
        LongestValidParentthese longestValidParentthese = new LongestValidParentthese();
        int res = longestValidParentthese.longestValidParentheses(s);
        Assert.assertEquals(4, res);
    }

    @Test
    public void test4() {
        String s = "()()";
        LongestValidParentthese longestValidParentthese = new LongestValidParentthese();
        int res = longestValidParentthese.longestValidParentheses(s);
        Assert.assertEquals(4, res);
    }
}
