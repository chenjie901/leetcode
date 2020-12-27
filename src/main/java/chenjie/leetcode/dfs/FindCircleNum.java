package chenjie.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            dfs(M, i, visited);
            count++;
        }
        return count;
    }

    private void dfs(int[][] friends, int i, Set<Integer> visited) {
        for (int j = 0; j < friends.length; j++) {
            if (friends[i][j] == 1 && !visited.contains(j)) {
                visited.add(j);
                dfs(friends, j, visited);
            }
        }
    }

}
