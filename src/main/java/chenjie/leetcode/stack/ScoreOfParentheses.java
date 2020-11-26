package chenjie.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> scoreStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                //0 表示左括号，在遇到)时需要判断如果前面的时数字，需要累加*2
                scoreStack.push(0);
            } else {
                if (scoreStack.peek() == 0) {
                    scoreStack.pop();
                    scoreStack.push(1);
                } else {
                    int temp = 0;
                    while (scoreStack.peek() != 0) {
                        temp += scoreStack.pop();
                    }
                    scoreStack.pop();
                    scoreStack.push(2 * temp);
                }
            }
        }
        int res = 0;
        while (!scoreStack.isEmpty()) {
            res += scoreStack.pop();
        }
        return res;
    }

    @Test
    public void test001() {
        String s = "()";
        Assert.assertEquals(1, scoreOfParentheses(s));
    }
    @Test
    public void test002() {
        String s = "(())";
        Assert.assertEquals(2, scoreOfParentheses(s));
    }

    @Test
    public void test003() {
        String s = "()(())";
        Assert.assertEquals(3, scoreOfParentheses(s));
    }
}
