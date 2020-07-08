package chenjie.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

public class ColorBoard {

    @Test
    public void test001() {
        int[][] grid = new int[][] {
                {1, 2, 2},
                {2, 3, 2}
        };

        int[][] expeced = new int[][] {
                {1, 3, 3},
                {2, 3, 3}
        };

        int[][] res = colorBorder(grid, 0, 1, 3);
        Assert.assertTrue(isSame(expeced, res));
    }

    @Test
    public void test002() {
        int[][] grid = new int[][] {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int[][] expeced = new int[][] {
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2},
        };

        int[][] res = colorBorder(grid, 1, 1, 2);
        Assert.assertTrue(isSame(expeced, res));
    }


    public boolean isSame(int[][] expeced, int[][] actual) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (expeced[i][j] != actual[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] visited;
    int R;
    int C;

    //1034
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        R = grid.length;
        C = grid[0].length;

        visited = new int[grid.length][grid[0].length];
        int oldColor = grid[r0][c0];
        dfs(grid, r0, c0, oldColor);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isBorder(i, j)) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private boolean isBorder(int r0, int c0) {
        if (visited[r0][c0] == 0) {
            return false;
        }
        int cnt = 0;
        for (int[] d : direction) {
            int r1 = r0 + d[0];
            int c1 = c0 + d[1];
            if (!inArea(r1, c1)) {
                continue;
            }
            if (visited[r1][c1] == 1) {
                cnt++;
            }
        }

        return cnt != 4 || r0 == R - 1 || c0 == C - 1;
    }

    public void dfs(int[][] grid, int r0, int c0, int color) {
        visited[r0][c0] = 1;

        for (int[] d : direction) {
            int r1 = r0 + d[0];
            int c1 = c0 + d[1];
            if (!inArea(r1, c1)) continue;

            if (visited[r1][c1] == 0 && grid[r1][c1] == color) {
                dfs(grid, r1, c1, color);
            }
        }
    }

    private boolean inArea(int r1, int c1) {
        if (r1 < 0 || r1 >= visited.length || c1 < 0 || c1 >= visited[0].length) {
            return false;
        }
        return true;
    }
}
