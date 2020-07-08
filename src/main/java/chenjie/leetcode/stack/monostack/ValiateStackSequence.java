package chenjie.leetcode.stack.monostack;

import org.junit.Test;

import java.util.Stack;

public class ValiateStackSequence {

    @Test
    public void testValidateStackSequences() {
        int[] pushed = new int[]{1, 2, 3, 4,5};
        int[] poped = new int[]{4, 5, 3, 2,1};
        System.out.println(validateStackSequences(pushed, poped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int cnt = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
                cnt++;
            }
        }
        return cnt == popped.length;
    }
}
