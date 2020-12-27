package chenjie.leetcode.dfs;

import org.junit.Assert;
import org.junit.Test;

public class MaxAreaOfIsland {
    int[] direction = new int[]{-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 && grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) {
            return 0;
        }
        //为什么，改了之后不恢复
        grid[r][c] = 0;
        int area = 1;
        for (int dir = 0; dir < 4; dir++) {
            int xNew = r + direction[dir];
            int yNew = c + direction[dir + 1];
            if (!inArea(grid, xNew, yNew)) {
                continue;
            }

            area += dfs(grid, xNew, yNew);
        }
        return area;
    }

    private boolean inArea(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return true;
        }
        return false;
    }

    @Test
    public void test001() {
        int[][] island = new int[][] {
                {0, 1}
        };
        Assert.assertEquals(1, maxAreaOfIsland(island));
    }
}
