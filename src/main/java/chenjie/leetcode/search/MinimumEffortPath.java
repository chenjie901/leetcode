package chenjie.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumEffortPath {
    int[] directions = {-1, 0, 1, 0, -1};

    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 999999;
        if (heights.length == 1 && heights[0].length == 1) {
            return 0;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean canReach = bfs(heights, mid);
            if (!canReach) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (bfs(heights, left)) {
            return left;
        }
        return Integer.MAX_VALUE;
    }

    private boolean bfs(int[][] height, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] visited = new int[height.length][height[0].length];
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == height.length - 1 && cur[1] == height[0].length - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int xNew = cur[0] + directions[i];
                int yNew = cur[1] + directions[i + 1];
                if (!inArea(height, xNew, yNew) || visited[xNew][yNew] == 1) {
                    continue;
                }
                if (Math.abs(height[xNew][yNew] - height[cur[0]][cur[1]]) > k) {
                    continue;
                }

                visited[xNew][yNew] = 1;
                queue.offer(new int[]{xNew, yNew});
            }
        }
        return false;
    }

    private boolean inArea(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return true;
        }
        return false;
    }

    @Test
    public void test001() {
        int[][] height = {{3}};
        Assert.assertEquals(0, minimumEffortPath(height));
    }
}
