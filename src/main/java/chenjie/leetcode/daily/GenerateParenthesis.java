package chenjie.leetcode.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    List<String> ans = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, "");
        return ans;
    }

    private void dfs(int n, String parenthesis) {
        if (parenthesis.length() == 2 *n) {
            if (isValid(parenthesis)) {
                ans.add(parenthesis);
            }
            return;
        }
        dfs(n, parenthesis + "(");
        dfs(n, parenthesis + ")");
    }

    private boolean isValid(String parenthesis) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < parenthesis.length(); i++) {
            if (parenthesis.charAt(i) == '(') {
                s.push(parenthesis.charAt(i));
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                s.pop();
            }
        }
        return s.isEmpty();
    }
}
