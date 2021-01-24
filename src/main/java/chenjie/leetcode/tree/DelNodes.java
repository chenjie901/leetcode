package chenjie.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DelNodes {
    List<TreeNode> ans = new LinkedList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        dfs(root, null, true, to_delete);
        return ans;
    }

    public void dfs(TreeNode root, TreeNode parent, boolean fromLeft, int[] to_delete) {
        if (root == null) {
            return;
        }
        dfs(root.left, root, true, to_delete);
        dfs(root.right, root, false,  to_delete);
        if (Arrays.stream(to_delete).anyMatch(c -> c == root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            if (root.left == null && root.right == null) {
                ans.add(root);
            }
            if (parent == null) {
                return;
            }
            if (fromLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }
}
