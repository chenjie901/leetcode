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
        Deque<Point> path = new LinkedList<>();
        Point start = new Point(0, 0, null);
        path.push(start);
        visited[0][0] = 1;
        dfs(graph, visited, start, path);
    }

    public void dfs(int[][] graph, int[][] visited, Point p, Deque<Point> path) {
        if (p.x == 2 && p.y == 2) {
            Point c = p;
            while (c.prev != null) {
                System.out.printf("%d\t", graph[c.x][c.y]);
                c = c.prev;
            }
            System.out.println();
        }

        for (int k = 0; k < 4; k++) {
            int xNew = p.x + dirX[k];
            int yNew = p.y + dirY[k];
            if (!inArea(graph, xNew, yNew) || visited[xNew][yNew] == 1) {
                continue;
            }

            visited[xNew][yNew] = 1;
            Point next = new Point(xNew, yNew, p);
            path.push(next);
            dfs(graph, visited, next, path);
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

    class Point {
        int x;
        int y;
        Point prev;

        public Point(int x, int y, Point prev) {
            this.x = x;
            this.y = y;
            this.prev = prev;
        }
    }
}
