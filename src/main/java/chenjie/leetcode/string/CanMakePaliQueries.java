package chenjie.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class CanMakePaliQueries {


    public boolean isPaliWord(int[][] dp, int left, int right, int k) {
        int oddCnt = 0;
        int[] cnt = new int[26];
        for (int j = 0; j < 26; j++) {
            cnt[j] = dp[right + 1][j] - dp[left ][j];
            if (cnt[j] % 2 != 0) {
                oddCnt++;
            }
            if (oddCnt == 2) {
                k--;
                oddCnt = 0;
            }
            if (k < 0) {
                return false;
            }
        }
        return true;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new LinkedList<>();
        int[][] dp = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.arraycopy(dp[i], 0, dp[i + 1], 0, 26);
            dp[i + 1][c - 'a']++;
        }

        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            int k = q[2];
            if (isPaliWord(dp, left, right, k)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    @Test
    public void test1() {
        String s="hunu";
        CanMakePaliQueries canMakePaliQueries = new CanMakePaliQueries();
        List<Boolean> res = canMakePaliQueries.canMakePaliQueries(s, new int[][]{{0, s.length() -1 , 1}});
        Assert.assertTrue(res.get(0));
    }

    @Test
    public void test2() {
        String s="aba";
        CanMakePaliQueries canMakePaliQueries = new CanMakePaliQueries();
        List<Boolean> res = canMakePaliQueries.canMakePaliQueries(s, new int[][]{{0, s.length() -1 , 0}});
        Assert.assertTrue(res.get(0));
    }
}
