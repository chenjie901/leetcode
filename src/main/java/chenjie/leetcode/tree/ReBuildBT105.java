package chenjie.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReBuildBT105 {

    @Test
    public void testBuildTreeByPreAndInOrder() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        String res = BSTreeUtil.serialByLevel(root);
        String expected = "3!9!20!#!#!15!7!#!#!#!#!";
        Assert.assertEquals("failed to buildTree", expected, res);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int nl, int nr) {
        if (pl > pr) {
            return null;
        }

        TreeNode parent = new TreeNode(preorder[pl]);
        int index = map.get(preorder[pl]);
        int size = index - nl;
        parent.left = buildTree(preorder, inorder, pl + 1, pl + size, nl, index - 1);
        parent.right = buildTree(preorder, inorder, pl + size + 1, pr, index + 1, nr);
        return parent;
    }
}
