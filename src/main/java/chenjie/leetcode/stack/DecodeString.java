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
}
