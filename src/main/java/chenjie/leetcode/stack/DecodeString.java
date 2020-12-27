package chenjie.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DecodeString {
    @Test
    public void testDecodeString() {
        String s = "a{b}c";
        Map<String, String> dict = new HashMap<>();
        dict.put("b", "a");
        Assert.assertEquals("fail", "aac", decode(s, dict));
    }

    @Test
    public void testDecodeString01() {
        String s = "a{b{b}}c";
        Map<String, String> dict = new HashMap<>();
        dict.put("b", "a");
        dict.put("ba", "ba");
        Assert.assertEquals("fail", "abac", decode(s, dict));
    }

    public String decode(String s, Map<String, String> dict) {
        int idx = 0;
        Stack<String> resStack = new Stack<>();
        String res = "";
        while (idx < s.length()) {
            if (s.charAt(idx) == '{') {
                resStack.add(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == '}') {
                StringBuffer sb = new StringBuffer(resStack.pop());
                if (dict.containsKey(res)) {
                    sb.append(dict.get(res));
                } else {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    public String[] dfs(String s, int idx) {
        StringBuffer res = new StringBuffer();
        int count = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == '[') {
                String[] tmp = dfs(s, idx + 1);
                idx = Integer.parseInt(tmp[0]);
                while (count > 0) {
                    res.append(tmp[1]);
                    count--;
                }
            } else if (c == ']') {
                return new String[]{String.valueOf(idx), res.toString()};
            } else if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else {
                res.append(c);
            }
            idx++;
        }
        return new String[]{res.toString()};
    }

    @Test
    public void test002() {
        decodeString("3[a]2[bc]");
    }
}
