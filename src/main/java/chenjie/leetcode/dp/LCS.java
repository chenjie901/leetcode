package chenjie.leetcode.dp;

import org.junit.Test;

public class LCS {

    int dp(String t1, String t2) {
        if ("".equals(t1) || "".equals(t2)) {
            return 0;
        }
        if (t1.charAt(t1.length() - 1) == t2.charAt(t2.length() - 1)) {
            return dp(t1.substring(0, t1.length() - 1), t2.substring(0, t2.length() -1)) + 1;
        } else {
            return Math.max(dp(t1.substring(0, t1.length() - 1), t2),dp(t1, t2.substring(0, t2.length() - 1)));
        }
    }

    @Test
    public void testLcs() {
        System.out.println(dp("abcde", "ace"));
    }

    @Test
    public void test001() {
        String t1 = "123456";
        System.out.println(t1.substring(0, t1.length() - 1));
    }
}