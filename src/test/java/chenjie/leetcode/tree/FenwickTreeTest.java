package chenjie.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FenwickTreeTest {
    @Test
    public void test01() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        FenwickTree fenwickTree = new FenwickTree(arr);
        Assert.assertEquals(6, fenwickTree.sum(2));
        Assert.assertEquals(7, fenwickTree.sum(2, 3));
        System.out.println(7 | (7 + 1));
    }
}