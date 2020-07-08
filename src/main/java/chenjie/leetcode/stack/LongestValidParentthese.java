package chenjie.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class LongestValidParentthese {
    public int longestValidParentheses1(String s) {
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
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek() + 1);
                    stack.pop();
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
        String s = "(()";
        LongestValidParentthese longestValidParentthese = new LongestValidParentthese();
        int res = longestValidParentthese.longestValidParentheses(s);
        Assert.assertEquals(2, res);
    }
}
