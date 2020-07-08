package chenjie.leetcode;

import chenjie.leetcode.tree.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class MaxDepth {

    @Test
    public void test001() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        root.left = left;

        System.out.println(maxDepth(root));

    }

    public  int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (null == node) {
            return true;
        }
        int val = node.val;

        if (lower != null && lower > val) {
            return false;
        }

        if (upper != null && val > upper) {
            return false;
        }

        if (!helper(node.left, lower, val)) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return  false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= inorder) {
                return false;
            }

            inorder = root.val;
            root = root.right;
        }
        return true;
    }




}
