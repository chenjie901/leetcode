package chenjie.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IsInterleave {
    int[][] memos1;
    int[][] memos2;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memos1 = new int[s3.length()][s1.length() + 1];
        memos2 = new int[s3.length()][s2.length() + 1];
        Arrays.stream(memos1).forEach(c -> Arrays.fill(c, -1));
        Arrays.stream(memos2).forEach(c -> Arrays.fill(c, -1));
        boolean maths2 =  matchS2(s3, 0, s2, 0, s1, 0);
        boolean matchs1 = matchS1(s3, 0, s2, 0, s1, 0);
        return matchs1 || maths2;
    }

    boolean matchS2(String s3, int idx3, String s2, int idx2, String s1, int idx1) {
        if (idx3 == s3.length() && idx2 == s2.length()) {
            return true;
        }
        if (memos2[idx3][idx2] != -1) {
            return memos2[idx3][idx2] == 1 ? true : false;
        }

        int j = idx2;
        for (int i = idx3; i < s3.length(); i++) {
            j = i - idx3 + idx2;
            if (j >= s2.length()) {
                return false;
            }
            if (s3.charAt(i) != s2.charAt(j)) {
                memos2[i][j] = 0;
                return false;
            }
            if (matchS1(s3, i + 1, s2, j + 1, s1, idx1)) {
                memos1[i][j] = 1;
                return true;
            }
        }
        memos2[idx3][idx2] = 0;
        return false;
    }


    boolean matchS1(String s3, int idx3, String s2, int idx2, String s1, int idx1) {
        if (idx3 == s3.length() && idx1 == s1.length()) {
            return true;
        }

        if (memos1[idx3][idx1] != -1) {
            return memos1[idx3][idx1] == 1 ? true : false;
        }

        int j = idx1;
        for (int i = idx3; i < s3.length(); i++) {
            j = i - idx3 + idx1;
            if (j >= s1.length()) {
                return false;
            }
            if (s3.charAt(i) != s1.charAt(j)) {
                memos1[i][j] = 0;
                return false;
            }
            if (matchS2(s3, i + 1, s2, idx2, s1, j + 1)) {
                memos2[i][j] = 1;
                return true;
            }

        }
        memos1[idx3][idx1] = 0;
        return false;
    }


    @Test
    public void test001() {
        Assert.assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        //Assert.assertTrue(matchS1("bcac", 0, "a", 0, "bcc", 0));
    }

    @Test
    public void test002() {
        Assert.assertTrue(isInterleave("a", "", "a"));
    }

    @Test
    public void test003() {
        Assert.assertFalse(isInterleave("", "abc", "ab"));
//        Assert.assertTrue(matchS1("aadbbbaccc", 5, "dbbca", 3, "aabcc", 3));
    }
}
