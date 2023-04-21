package chenjie.leetcode.dfs;

import chenjie.leetcode.tree.TreeNode;

public class maxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mi, int ma) {
        if (root == null) {
            return 0;
        }
        int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        mi = Math.min(root.val, mi);
        ma = Math.max(root.val, ma);
        diff = Math.max(diff, dfs(root.left, mi, ma));
        diff = Math.max(diff, dfs(root.right, mi, ma));
        return diff;
    }
}
