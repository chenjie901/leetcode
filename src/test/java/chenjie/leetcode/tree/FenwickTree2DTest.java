package chenjie.leetcode.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class FenwickTree2DTest {

    @Test
    public void test01() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        FenwickTree2D fenwickTree2D = new FenwickTree2D(arr);
        assertEquals(12, fenwickTree2D.sum(1, 1));
        //fenwickTree2D.sum(1, 2);
        assertEquals(11, fenwickTree2D.sum(1, 1, 1, 2));
    }

}