package chenjie.leetcode.tree;

import org.junit.Test;

public class MaxPathSum124 {

    @Test
    public void testMaxPathSum() {
        String tree = "-10!9!#!#!20!15!#!#!7!#!#!";
        Integer[] tree1 = new Integer[]{-10, 9, 20, null, null, 15, 7};
        TreeNode root = BSTreeUtil.reconstructByLevel(tree1);
        System.out.println(maxPathSum(root));
    }

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
           return 0;
        }

        int leftPathSum = Math.max(dfs(root.left), 0);
        int rightPathSum = Math.max(dfs(root.right), 0);
        //包含当前节点，可能为最大路径和
        int newPathSum = root.val + leftPathSum + rightPathSum;

        if (newPathSum > maxPathSum) {
            maxPathSum = newPathSum;
        }
        //包含左边，或后边的路径，后序到父节点判读
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
