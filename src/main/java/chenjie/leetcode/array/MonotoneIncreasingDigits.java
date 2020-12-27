package chenjie.leetcode.array;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MonotoneIncreasingDigits {
    Map<Integer, Boolean> memo = new HashMap<>();
    public int monotoneIncreasingDigits1(int N) {
        for (int i = N; i >= 0; --i) {
            if (check(i)) {
                return i;
            }
        }
        return 0;
    }

    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        char[] chars = str.toCharArray();
        int anchor = str.length();
        for (int i = chars.length - 1; i > 0; --i) {
            if (chars[i - 1] > chars[i]) {
                anchor = i;
                chars[i - 1]--;
            }
        }

        for (int i = anchor; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.valueOf(new String(chars));
    }

    private boolean check(int n) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        while (n > 0) {
            if (memo.containsKey(n)) {
                return memo.get(n);
            }
            int low = n >>> 1;
            ++total;
            while (!stack.isEmpty() && stack.peek() < low) {
                stack.pop();
            }
            stack.push(low);
            if (stack.size() < total) {
                memo.put(n, false);
                return false;
            }
            n /= 10;

        }
        memo.put(n, total == stack.size());
        return total == stack.size();
    }

    @Test
    public void test001() {
        System.out.println(monotoneIncreasingDigits(401695217));
    }

}
