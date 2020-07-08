package chenjie.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReBuildBT883 {

    @Test
    public void testBuildTreeByPreAndInOrder() {
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] postorder = new int[]{5, 4, 2, 6, 7, 3, 1};
        TreeNode root = constructFromPrePost(preorder, postorder);
        String res = BSTreeUtil.serialByLevel(root);
        String expected = "1!2!3!4!5!6!7!#!#!#!#!#!#!#!#!";
        Assert.assertEquals("failed to buildTree", expected, res);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        //base case
        if (preStart > preEnd ) {
            return null;
        }

        if(preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        TreeNode parent = new TreeNode(pre[preStart]);
        int pleftVal = pre[preStart + 1];
        int index = map.get(pleftVal);
        int size = index - postStart;
        parent.left = constructFromPrePost(pre, post, preStart + 1, preStart + size + 1, postStart, index);
        parent.right = constructFromPrePost(pre, post, preStart + size + 2, preEnd, index + 1, postEnd - 1);
        return parent;
    }

}
