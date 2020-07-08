package chenjie.leetcode.bfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void bfs(Queue<int[]> queue, int[][] arr) {
        int[][] visited = new int[arr.length][arr[0].length];
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] v = queue.poll();
                visited[v[0]][v[1]] = level;
                for (int[] dir : dirs) {
                    int xNew = v[0] + dir[0];
                    int yNew = v[1] + dir[1];
                    if (!inArea(arr, xNew, yNew) || visited[xNew][yNew] != 0) {
                        continue;
                    }

                    if (arr[xNew][yNew] == 1) {
                        continue;
                    }

                    queue.offer(new int[]{xNew, yNew});
                }
            }
            System.out.printf("levle-->%d\n", level);
            Arrays.stream(visited).forEach(a -> System.out.println(Arrays.toString(a)));
        }
    }

    public boolean inArea(int[][] arr, int x, int y) {
        return x >= 0 && x < arr.length && y >= 0 && y < arr[0].length;
    }

    @Test
    public void test001() {
        int[][] arr = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        queue.offer(new int[]{0, 3});
        bfs(queue, arr);
    }

}
