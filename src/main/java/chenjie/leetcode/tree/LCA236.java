package chenjie.leetcode.tree;

public class LCA236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode leftlca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightlca = lowestCommonAncestor(root.right, p, q);

        if (leftlca == null) {
            return rightlca;
        }
        if (rightlca == null) {
            return leftlca;
        }
        return root;
    }
}
