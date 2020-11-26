package chenjie.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[top] == stack.peek()) {
                top++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test001() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        Assert.assertTrue(validateStackSequences(pushed, poped));
    }
}
