package chenjie.leetcode.tree;

//1339. 分裂二叉树的最大乘积
public class MaxProduct {
    long total;
    long ans = Integer.MIN_VALUE;
    long totalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + totalSum(root.left) + totalSum(root.right);
    }
    private long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long ls = dfs(root.left);
        long rs = dfs(root.right);
        ans = Math.max(ls * (total - ls), ans);
        ans = Math.max(rs * (total - rs), ans);
        return root.val + ls + rs;
    }
    public int maxProduct(TreeNode root) {
        total = totalSum(root);
        dfs(root);
        return (int)(ans % (1e9 + 7));
    }
}
