package chenjie.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BSTree {


    @Test
    public void reconstructBSTByPreOrder() {
        String preOrder = "1!2!4!#!#!#!3!#!5!#!#!";
        TreeNode treeNode = BSTreeUtil.reconByPreString(preOrder);
        BSTreeUtil.printPre(treeNode);
        System.out.println(BSTreeUtil.serialByPre(treeNode));
    }

    @Test
    public void reconstructByLevel() {
        String levelOrder = "1!2!3!4!#!#!5!#!#!#!#!";
        TreeNode treeNode =  BSTreeUtil.reconstructByLevel(levelOrder);
        BSTreeUtil.printPre(treeNode);

        Assert.assertEquals("failed to reconstruct tree", levelOrder, BSTreeUtil.serialByLevel(treeNode));
    }

    @Test
    public void reconstructByLevel1() {
        String levelOrder = "1!2!3!4!#!#!5!#!#!#!#!";
        TreeNode treeNode =  BSTreeUtil.reconstructByLevel(levelOrder);
        BSTreeUtil.printPre(treeNode);

        Assert.assertEquals("failed to reconstruct tree", levelOrder, BSTreeUtil.serialByLevel(treeNode));
    }

    @Test
    public void test002() {
        String treeStr = "3!9!#!#!20!15!#!#!7!#!#!";
        TreeNode root = BSTreeUtil.reconByPreString(treeStr);
        levelOrder1(root);
        for (List<Integer> level : levelOrder1(root) ) {
            System.out.println(Arrays.toString(level.stream().mapToInt(Integer::intValue).toArray()));
        }
    }

    /**
     * 二叉树的层级遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        //queue中保存的就是前一层节点
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
