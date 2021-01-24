package chenjie.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class DistanceK {
    int targetDist = 0;
    List<Integer> ans = new LinkedList<>();
    TreeNode target;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        targetDist = K;
        this.target = target;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftDist = dfs(root.left);
        int rightDist = dfs(root.right);
        if (root == target) {
            ans.add(root.val);
            return 0;
        }

        if (leftDist == -1) {
            subTreeAdd(root, leftDist);
        } else if (rightDist != -1) {
            if (rightDist == targetDist) {
                ans.add(root.val);
            }
            subTreeAdd(root, rightDist);
        } else {
            return -1;
        }
        return 0;
    }


    private void subTreeAdd(TreeNode root, int dist) {
        if (root == null) {
            return;
        }
        if (dist == targetDist) {
            ans.add(root.val);
        }
        subTreeAdd(root.left, dist + 1);
        subTreeAdd(root.right, dist + 1);
    }


}
