package chenjie.leetcode;

import org.junit.Test;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Island {



    @Test
    public void testArea() {
        int[][] grid = {
                {0,0,1,1},
                {0,1,1,1},
                {0,0,1,0}
        };
        boolean[][] visited = new boolean[3][4];;
        System.out.println(dfs(grid, 1, 1, visited));
    }

    int[][] direction = {{0,-1}, {1,0}, {0, 1}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int colum = grid[0].length;

        int maxPath = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0 ; y < colum; y++) {
                if (grid[x][y] == 1) {
                    boolean[][] visited = new boolean[row][colum];
                    maxPath = Math.max(maxPath, dfs(grid, x, y, visited));
                }
            }
        }
        return maxPath;

    }

    public boolean inArea(int[][] grid, int i, int j) {
        if (i >= 0 && j < grid[0].length && j >=0 && i < grid.length) {
            return true;
        }
        return false;
    }

    public int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if(visited[x][y] == true) {
            return 0;
        }

        int path = 1;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x+ direction[i][0];
            int newY = y + direction[i][1];
            if (inArea(grid, newX, newY) && grid[newX][newY] == 1 && !visited[newX][newY]) {
                path += dfs(grid, newX,newY, visited);
            }

        }
        return path;
    }
}
