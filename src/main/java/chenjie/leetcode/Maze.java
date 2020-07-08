package chenjie.leetcode;

import org.junit.Test;

import java.util.*;

public class Maze {

    public int[][] maze = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

//    public int[][] maze = {
//            {5,6},
//            {8,9}
//    };

    public int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean[][] visited = new boolean[maze.length][maze[0].length];
    List<Integer> res = new LinkedList<>();

    class Pos {
        int x, y;
        Pos p;

        public Pos(int x, int y, Pos p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }

    }

    @Test
    public void testDfs() {
        dfs(new Pos(0, 0, null));
    }

    public void dfs(Pos cur) {
        visited[cur.x][cur.y] = true;

        if (maze[cur.x][cur.y] == 9) {
            printPath(cur);
        }

        for (int i = 0; i < 4; i++) {
            int newX = cur.x + direction[i][0];
            int newY = cur.y + direction[i][1];
            Pos p = new Pos(newX, newY, cur);
            if (inArea(p) && !visited[newX][newY]) {
                dfs(p);
                visited[newX][newY] = false;
            }
        }

    }

    @Test
    public void testBfs() {
        bfs(new Pos(0, 0, null));
    }

    public void bfs(Pos root) {
        Queue<Pos> queue = new LinkedList<>();

        queue.offer(root);
        visited[root.x][root.y] = true;

        while (!queue.isEmpty()) {
            List<Pos> level = new LinkedList<>();
            for (int j = queue.size(); j > 0; j--) {
                Pos cur = queue.poll();
                visited[cur.x][cur.y] = true;
                if (maze[cur.x][cur.y] == 9) {
                    printPath(cur);
//                    visited[cur.x][cur.y] = false;
                }
                level.add(cur);
                for (int i = 0; i < 4; i++) {
                    int newX = cur.x + direction[i][0];
                    int newY = cur.y + direction[i][1];
                    Pos p = new Pos(newX, newY, cur);
                    if (inArea(p) && !visited[newX][newY]) {
//                        visited[newX][newY] = true;
                        queue.offer(p);
                    }
                }
            }
//            for (Pos p : level) {
//                System.out.printf("<%d>", maze[p.x][p.y]);
//            }
//            System.out.println();
        }
    }


    public boolean inArea(Pos pos) {
        if (pos.x >= 0 && pos.x < maze.length && pos.y >= 0 && pos.y < maze[0].length) {
            return true;
        }
        return false;
    }

    public void printPath(Pos p) {
        while (p != null) {
            System.out.printf("<%d><=", maze[p.x][p.y]);
            p = p.p;
        }
        System.out.println();
    }
}
