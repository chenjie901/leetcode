package chenjie.leetcode.bfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//934
public class ShortestBridge {
    int[] direction = {-1, 0, 1, 0, -1};

    public int shortestBridge(int[][] A) {
        color(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int xNew = cur[0] + direction[j];
                    int yNew = cur[1] + direction[j + 1];
                    if (!inArea(A, xNew, yNew) || A[xNew][yNew] == 3) {
                        continue;
                    }
                    if(A[xNew][yNew] == 1) {
                        return dist;
                    }
                    A[xNew][yNew] = 3;
                    queue.offer(new int[]{xNew, yNew});
                }

            }
            dist++;
        }
        return dist;
    }

    private void color(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 2;
                    dfs(A, 2, i, j);
                    return;
                }
            }
        }
    }

    private void dfs(int[][] matrix, int islandNum, int curx, int cury) {
        for (int i = 0 ; i < 4; i++) {
            int xNew = curx + direction[i];
            int yNew = cury + direction[i + 1];
            if (!inArea(matrix, xNew, yNew) || matrix[xNew][yNew] == 0 || matrix[xNew][yNew] == islandNum) {
                continue;
            }
            matrix[xNew][yNew] = islandNum;
            dfs(matrix, islandNum, xNew, yNew);
        }
    }

    private boolean inArea(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return true;
        }
        return false;
    }

    @Test
    public void test001() {
        int[][] arr = {
                {1, 0, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        Assert.assertEquals(2, shortestBridge(arr));
    }

    @Test
    public void test002() {
        int[][] arr = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        Assert.assertEquals(1, shortestBridge(arr));
    }

}
