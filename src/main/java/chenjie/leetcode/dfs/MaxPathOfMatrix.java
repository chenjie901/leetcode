package chenjie.leetcode.dfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaxPathOfMatrix {

    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    @Test
    public void test001() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] visited = new int[matrix.length][matrix[0].length];
        List<Node> path = new LinkedList<>();
        path.add(new Node(0,0));
        visited[0][0] = 1;
        dfs(matrix, visited, 0, 0, path);
    }

    @Test
    public void test002() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] visited = new int[matrix.length][matrix[0].length];
        List<Node> path = new LinkedList<>();
        path.add(new Node(0,0));
        visited[0][0] = 1;
        dfs(matrix, visited, 0, 0, path);
    }

    public void dfs(int[][] A, int[][] visited, int r, int c, List<Node> path) {
        if (r == A.length - 1 && c == A[0].length - 1) {
            path.stream().forEach(n -> System.out.print(n));
            System.out.println();
            return;
        }

        for (int[] d : direction) {
            int r1 = d[0] + r;
            int c1 = d[1] + c;
            if (inArea(A, r1, c1) && visited[r1][c1] == 0) {
                visited[r1][c1] = 1;
                path.add(new Node(r1, c1));
                dfs(A, visited, r1, c1, path);
                visited[r1][c1] = 0;
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test003() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6}
        };

        maxPath(matrix);
    }

    public void maxPath(int[][] A) {
        Stack<Node> stack = new Stack<>();
        int R = A.length;
        int C = A[0].length;
        int[][] visited = new int[R][C];
        List<Node> path = new LinkedList<>();
        stack.push(new Node(0, 0));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            visited[node.r][node.c] = 1;
            path.add(node);
            if (node.r == R - 1 && node.c == C - 1) {
                System.out.println("find a path");
                path.stream().forEach(n -> System.out.print(n));
                System.out.println();
                stack.push(node);
                path.remove(path.size() - 1);
                visited[node.r][node.c] = 0;
            }


            for (int[] d: direction) {
                int r1 = node.r + d[0];
                int c1 = node.c + d[1];
                if (inArea(A, r1, c1) && visited[r1][c1] == 0) {
                    stack.push(new Node(r1, c1));
                }
            }
        }
    }

    public boolean inArea(int[][] A, int r, int c) {
        return r >= 0 && r < A.length && c >= 0 && c < A[0].length;
    }

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return String.format("<%d,%d> ", r, c);
        }
    }

}
