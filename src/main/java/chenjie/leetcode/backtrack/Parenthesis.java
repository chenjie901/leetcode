package chenjie.leetcode.backtrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Parenthesis {
    List<String> res = new LinkedList<>();

    @Test
    public void testGenerateParenthesis() {
        List<String> res1 = generateParenthesis(3);
        res1.stream().forEach(s -> System.out.println(s));
    }

    public List<String> generateParenthesis(int n) {
        backtrack(n,  "");
        return res;
    }

    boolean valid(String parentheis) {
        Stack<Character> stack = new Stack<>();
        for (char c : parentheis.toCharArray()) {
            if (c=='(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public void backtrack(int n, String parentthesis) {
        if (parentthesis.length() <= 2*n) {
            if (parentthesis.length() == 2*n && valid(parentthesis)) {
                res.add(parentthesis);
            } else {
                backtrack(n , parentthesis + "(");
                backtrack(n, parentthesis + ")");
            }
        }
    }
}
