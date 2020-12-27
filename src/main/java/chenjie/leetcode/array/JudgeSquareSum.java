package chenjie.leetcode.array;

import org.junit.Test;
import static org.junit.Assert.*;

public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int)Math.sqrt(c);
        while (i <= j) {
            int ii = i * i;
            int jj = j * j;
            if (ii + jj == c) {
                return true;
            } else if (ii + jj > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    @Test
    public void test001() {
        assertTrue(judgeSquareSum(1000000));
    }
}
