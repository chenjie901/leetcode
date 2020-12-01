package chenjie.leetcode.dfs;

import org.junit.Test;

import java.util.*;

public class Dfs {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};

    @Test
    public void test001() {
        int[][] graph = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] visited = new int[graph.length][graph[0].length];
        Deque<int[]> path = new LinkedList<>();
        path.push(new int[]{0, 0});
        visited[0][0] = 1;
        dfs(graph, visited, 0, 0, path);
    }

    public void dfs(int[][] graph, int[][] visited, int r0, int c0, Deque<int[]> path) {
        if (r0 == 2 && c0 == 2) {
            Iterator<int[]> iterator = path.descendingIterator();
            while (iterator.hasNext()) {
                int[] c = iterator.next();
                System.out.printf("%d\t", graph[c[0]][c[1]]);
            }
            System.out.println();
        }

        for (int k = 0; k < 4; k++) {
            int xNew = r0 + dirX[k];
            int yNew = c0 + dirY[k];
            if (!inArea(graph, xNew, yNew) || visited[xNew][yNew] == 1) {
                continue;
            }

            visited[xNew][yNew] = 1;
            path.push(new int[]{xNew, yNew});
            dfs(graph, visited, xNew, yNew, path);
            visited[xNew][yNew] = 0;
            path.pop();
        }
    }

    private boolean inArea(int[][] graph, int x, int y) {
        if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) {
            return false;
        }
        return true;
    }
}
