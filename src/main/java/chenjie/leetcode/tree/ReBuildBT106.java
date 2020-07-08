package chenjie.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReBuildBT106 {

    @Test
    public void testBuildTreeByPreAndInOrder() {
        int[] inorder = new int[]{9, 3,  15, 20,7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        String res = BSTreeUtil.serialByLevel(root);
        String expected = "3!9!20!#!#!15!7!#!#!#!#!";
        Assert.assertEquals("failed to buildTree", expected, res);
    }


    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int pl, int pr, int nl, int nr) {
        if (pl > pr) {
            return null;
        }
        TreeNode parent = new TreeNode(postorder[pr]);
        int index = map.get(postorder[pr]);
        int size = index - nl;
        parent.left = buildTree(inorder, postorder, pl, pl + size - 1, nl, index - 1);
        parent.right = buildTree(inorder, postorder, pl + size, pr - 1, index + 1, nr);
        return parent;
    }


}
