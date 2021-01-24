package chenjie.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryTreePaths {
    List<String> paths = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return paths;
        }
        backtrace(root, new LinkedList<>());
        return paths;
    }

    public void backtrace(TreeNode root, Deque<Integer> path) {
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for (Integer item : path) {
                sb.append(item);
                sb.append("->");
            }
            sb.append(root.val);
            paths.add(sb.toString());
        }

        path.addLast(root.val);
        if (root.left != null) {
            backtrace(root.left, path);
        }
        path.removeLast();

        path.addLast(root.val);
        if (root.right != null) {
            backtrace(root.right, path);
        }
        path.removeLast();
    }


}
