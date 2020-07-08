package chenjie.leetcode.stack.monostack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class MonoStack {

    @Test
    public void testTemperatures() {
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(t)));
    }
    //739
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int top = stack.peek();
                res[top] = i - top;
                stack.pop();
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }

        return res;
    }

    @Test
    public void testLeftLarge() {
        leftLarge1(new int[]{4, 3, 2, 1});
    }

    public void leftLarge(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        System.out.println(Arrays.toString(res));
    }

    public void leftLarge1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        System.out.println(Arrays.toString(res));
    }
}
