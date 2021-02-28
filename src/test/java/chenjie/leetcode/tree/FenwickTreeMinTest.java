package chenjie.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FenwickTreeMinTest {

    @Test
    public void test01() {
        int[] arr = {2, 3, 1, 8, 3, 1};
        FenwickTreeMin fenwickTreeMin = new FenwickTreeMin(arr);
        Assert.assertEquals(1, fenwickTreeMin.getMin(2));
        Assert.assertEquals(2, fenwickTreeMin.getMin(1));
    }
}