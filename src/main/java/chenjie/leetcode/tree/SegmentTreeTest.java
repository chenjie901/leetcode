package chenjie.leetcode.tree;

import org.junit.Test;

public class SegmentTreeTest {


    @Test
    public void test001() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree segTree = new SegmentTree(nums);
        System.out.println(segTree);
    }
}
