package chenjie.leetcode.misc;

import static org.junit.Assert.*;
import org.junit.Test;
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left + 1) /2;
            int sqrt = x/mid;
            //开方出来的值比mid还小，说名mid选大了
            if (sqrt < mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    @Test
    public void test001() {
        assertEquals(46339, mySqrt(2147395599));
    }
}
