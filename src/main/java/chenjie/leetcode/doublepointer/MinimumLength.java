package chenjie.leetcode.doublepointer;

import org.junit.Assert;
import org.junit.Test;

//1750. 删除字符串两端相同字符后的最短长度
public class MinimumLength {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return right - left + 1;
            }
            while (left < s.length() - 1 && s.charAt(left) == s.charAt(left + 1)) {
                left++;
            }
            while (right > 0 && s.charAt(right) == s.charAt(right - 1)) {
                right--;
            }
            left++;
            right--;
        }

        if (left == right) {
            return 1;
        }
        return 0;
    }

    @Test
    public void test001() {
        Assert.assertEquals(0, minimumLength("aa"));
        Assert.assertEquals(1, minimumLength("aba"));
        Assert.assertEquals(1, minimumLength("a"));
    }
}
