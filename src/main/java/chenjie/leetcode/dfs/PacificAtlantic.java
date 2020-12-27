package chenjie.leetcode.dfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlantic {
    int[] directions = new int[]{-1, 0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 && matrix[0].length == 0) {
            return new LinkedList<>();
        }
        int m = matrix.length;

        int n = matrix[0].length;
        int[][] canReachPacific = new int[m][n];
        int[][] canReachAltlantic = new int[m][n];

        for (int i = 0; i < m; i++) {
            canReachPacific[i][0] = 1;
            dfs(matrix, canReachPacific, i, 0);
            canReachAltlantic[i][n - 1] = 1;
            dfs(matrix, canReachAltlantic, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            canReachPacific[0][i] = 1;
            dfs(matrix, canReachPacific, 0, i);
            canReachAltlantic[m - 1][i] = 1;
            dfs(matrix, canReachAltlantic, m - 1, i);
        }

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachAltlantic[i][j] == 1 && canReachPacific[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int[][] visited, int r, int c) {
//        if (visited[r][c] == 1) {
//            return;
//        }
//        visited[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int xNew = r + directions[i];
            int yNew = c + directions[i + 1];
            if (!inArea(matrix, xNew, yNew) || visited[xNew][yNew] == 1) {
                continue;
            }
            //不能从高往低走
            if (matrix[r][c] > matrix[xNew][yNew]) {
                continue;
            }

            visited[xNew][yNew] = 1;
            dfs(matrix, visited, xNew, yNew);
        }
    }

    private boolean inArea(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return true;
        }
        return false;
    }

}
