package chenjie.leetcode.tree;

import chenjie.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTreeUtil {
    public static String serialByPre(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }

    public static String serialByLevel(TreeNode root) {
        if (root == null) {
            return "#!";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String res = root.val + "!";
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                res += treeNode.left.val + "!";
                queue.offer(treeNode.left);
            } else {
                res += "#!";
            }

            if (treeNode.right != null) {
                res += treeNode.right.val + "!";
                queue.offer(treeNode.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    public static TreeNode reconstructByLevel(String str) {
        String[] values = str.split("!");
        int index = 0;
        TreeNode treeNode = getNode(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (null != treeNode) {
            queue.offer(treeNode);
        }
        while (!queue.isEmpty()) {
            TreeNode treeNode1 = queue.poll();
            treeNode1.left = getNode(values[index++]);
            treeNode1.right = getNode(values[index++]);
            if (treeNode1.left != null) {
                queue.offer(treeNode1.left);
            }
            if (treeNode1.right != null) {
                queue.offer(treeNode1.right);
            }
        }
        return treeNode;
    }

    public static TreeNode reconstructByLevel(Integer[] bst) {
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        Integer first = bst[index++];
        TreeNode root = null;
        if (null != first) {
            root = new TreeNode(first);
            queue.add(root);
        }

        while (!queue.isEmpty() && index <= bst.length - 2) {
            TreeNode n = queue.poll();
            Integer l = bst[index++];
            Integer r = bst[index++];
            n.left = l == null ? null : new TreeNode(l);
            n.right = r == null ? null : new TreeNode(r);

            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
        return root;
    }


    private static TreeNode getNode(String s) {
        if (s.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(s));
    }


    public static TreeNode reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }

        return reconPreOrder(queue);
    }

    /**
     * 通过前序反序列化二叉树
     * @param queue
     * @return
     */
    private static TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = reconPreOrder(queue);
        root.right = reconPreOrder(queue);
        return root;
    }

    public static void printPre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.printf("%d ", node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }
}
